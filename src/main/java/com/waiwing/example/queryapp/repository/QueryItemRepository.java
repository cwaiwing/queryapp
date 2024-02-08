package com.waiwing.example.queryapp.repository;

import com.waiwing.example.queryapp.model.QueryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface QueryItemRepository extends MongoRepository<QueryItem, Integer> {

    @Query( "{ 'id' : ?0 }")
    QueryItem findItemById(int id);



    public long count();
}
