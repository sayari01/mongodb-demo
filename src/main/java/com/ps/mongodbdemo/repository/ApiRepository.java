package com.ps.mongodbdemo.repository;

import com.ps.mongodbdemo.model.ApiDetails;
import com.ps.mongodbdemo.model.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ApiRepository extends MongoRepository<ApiDetails, String> {
    @Query("{name:'?0'}")
    ApiDetails  findItemByName(String name);
}
