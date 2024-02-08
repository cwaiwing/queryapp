package com.waiwing.example.queryapp.service;

import com.waiwing.example.queryapp.model.QueryItem;

import java.util.List;

public interface IQueryService {
    List<QueryItem> findAll();

    QueryItem findItemById(int id);

    void addItem(QueryItem queryItem);
}
