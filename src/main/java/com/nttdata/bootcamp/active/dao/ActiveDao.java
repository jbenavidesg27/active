package com.nttdata.bootcamp.active.dao;

import com.nttdata.bootcamp.active.model.Active;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * DAO Active connect Mongo.
 *
 */
public interface ActiveDao extends ReactiveMongoRepository<Active, String> {

}