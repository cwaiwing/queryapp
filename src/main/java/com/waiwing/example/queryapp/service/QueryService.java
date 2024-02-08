package com.waiwing.example.queryapp.service;

import com.waiwing.example.queryapp.model.QueryItem;
import com.waiwing.example.queryapp.repository.QueryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryService implements IQueryService {

    @Autowired
    QueryItemRepository queryItemRepository;
    @Override
    public List<QueryItem> findAll(){
        return queryItemRepository.findAll();
    }

    @Override
    public QueryItem findItemById(int id){
        return queryItemRepository.findItemById(id);
    }

    @Override
    public void addItem(QueryItem queryItem){
        queryItemRepository.save(queryItem);
    }


}
