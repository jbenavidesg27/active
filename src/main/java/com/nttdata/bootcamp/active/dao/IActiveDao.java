package com.nttdata.bootcamp.active.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.nttdata.bootcamp.active.model.Active;

public interface IActiveDao extends ReactiveMongoRepository<Active, String>{

}