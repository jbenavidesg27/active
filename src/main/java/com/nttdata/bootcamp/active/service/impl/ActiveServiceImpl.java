package com.nttdata.bootcamp.active.service.impl;

import com.nttdata.bootcamp.active.dao.ActiveDao;
import com.nttdata.bootcamp.active.model.Active;
import com.nttdata.bootcamp.active.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service implements Active.
 *
 */
@Service
public class ActiveServiceImpl implements ActiveService {
  
  @Autowired
  ActiveDao iActive;

  @Override
  public Mono<Active> save(Active active) {
    return iActive.save(active);
  }
  
  @Override
  public Mono<Active> update(Active active) {
    return iActive.save(active);
  }

  @Override
  public Flux<Active> findAll() {
    return iActive.findAll();
  }

  @Override
  public Mono<Active> findById(String id) {
    return iActive.findById(id);
  }
  
  @Override
  public Mono<Void> deleteById(String id) {
    return iActive.deleteById(id);
  }
}
