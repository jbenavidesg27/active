package com.nttdata.bootcamp.active.controller;

import com.nttdata.bootcamp.active.model.Active;
import com.nttdata.bootcamp.active.service.ActiveService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Rest.
 *
 */
@RestController
@RequestMapping("/active")
public class ActiveController {
  
  @Autowired
  ActiveService activeService;
  
  /**
   * Peticiones Rest.
   * List all active.
   * 
   */
  @GetMapping
  public Mono<ResponseEntity<Flux<Active>>>  findAll() {
    Flux<Active> fx = activeService.findAll();
    return Mono.just(ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(fx));
  }
  
  /**
   * List Active for Id.
   * 
   */
  @GetMapping("/{id}")
  public Mono<ResponseEntity<Active>> findById(@PathVariable("id") String id) {
    return activeService.findById(id)
        .map(p -> ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(p));
  }
  
  /**
   * Delete for Id.
   * 
   */
  @GetMapping("/delete/{id}")
  public Mono<ResponseEntity<Void>> deleteById(@PathVariable("id") String id) {
    return activeService.findById(id)
        .flatMap(x -> {
          Mono<Void> delete = activeService.deleteById(id);
          return delete; })
        .map(x -> ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(x))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }
  
  /**
   * Save Active.
   * 
   */
  @PostMapping
  public Mono<ResponseEntity<Active>> save(@RequestBody Active activ, final ServerHttpRequest req) {
    return activeService.save(activ)
        .map(p -> ResponseEntity
        .created(URI.create(req.getURI().toString().concat("/").concat(p.getId())))
            .contentType(MediaType.APPLICATION_JSON)
            .body(p));
  }
  
  /**
   * Update active for Id.
   * 
   */
  @PutMapping("/{id}")
  public Mono<ResponseEntity<Active>> update(@PathVariable("id") String id, 
      @RequestBody Active active) {
    Mono<Active> monoBody = Mono.just(active);
    Mono<Active> monoBd = activeService.findById(id);
    return monoBd.zipWith(monoBody, (bd, ps) -> {
      bd.setId(id);
      bd.setCredit(ps.getCredit());
      bd.setCreditAmount(ps.getCreditAmount());
      bd.setCodePerson(ps.getCodePerson());
      bd.setCreditDate(ps.getCreditDate());
      bd.setPeriod(ps.getPeriod());
      return bd;
    })
        .flatMap(activeService::update)
        .map(y -> ResponseEntity.ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(y))
        .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

}
