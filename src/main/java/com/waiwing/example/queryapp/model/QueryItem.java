package com.waiwing.example.queryapp.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Document("queryitems")
@Data
public class QueryItem implements Serializable {

    @Id
    private int id;
    private String name;
    private String context;

    public QueryItem (){
        super();
    }
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContext() {
        return context;
    }

    public QueryItem(int id, String name, String context){
        super();
        this.id = id;
        this.name = name;
        this.context = context;
    }

    @Override
    public String toString() {
        return "QueryItem{id="+id+", name="+name+", context="+context+"}";
    }
}
