package com.ps.mongodbdemo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ps.mongodbdemo.model.ApiDetails;

public interface ApiRepository extends MongoRepository<ApiDetails, String> {
    @Query("{name:'?0'}")
    ApiDetails findItemByName(String name);
}
