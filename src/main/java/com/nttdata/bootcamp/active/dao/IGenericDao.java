package com.nttdata.bootcamp.active.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IGenericDao<T,ID> extends ReactiveMongoRepository<T, ID> {

}