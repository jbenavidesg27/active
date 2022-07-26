package com.nttdata.bootcamp.active.service;

import com.nttdata.bootcamp.active.model.Active;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service to Active.
 *
 */
public interface ActiveService {
  Mono<Active> save(Active active);
  
  Mono<Active> update(Active active);
  
  Flux<Active> findAll();
  
  Mono<Active> findById(String id);
  
  Mono<Void> deleteById(String id);
}
