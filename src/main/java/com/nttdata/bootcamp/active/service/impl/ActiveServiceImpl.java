package com.nttdata.bootcamp.active.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.bootcamp.active.dao.IActiveDao;
import com.nttdata.bootcamp.active.model.Active;
import com.nttdata.bootcamp.active.service.IActiveService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ActiveServiceImpl implements IActiveService {
	
	@Autowired
	IActiveDao iActive;

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
}
