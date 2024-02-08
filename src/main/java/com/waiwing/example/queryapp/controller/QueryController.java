package com.waiwing.example.queryapp.controller;

import com.waiwing.example.queryapp.model.QueryItem;
import com.waiwing.example.queryapp.service.IQueryService;
import com.waiwing.example.queryapp.service.QueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QueryController {
    Logger logger = LoggerFactory.getLogger(QueryController.class);
    @Autowired
    private IQueryService queryService;
    @RequestMapping(value="/getAllItem")
    public List<QueryItem> getAll()
    {
        return queryService.findAll();
    }

    @GetMapping(value = "/", produces = "application/json")
    public List<QueryItem> getAllItems() {
        List<QueryItem> list = queryService.findAll();
        list.forEach(a-> logger.info(a.toString()));
        return list;
    }
    @GetMapping(value="/query/{id}", produces = "application/json")
    public QueryItem getItemById(@PathVariable int id) {

        logger.info("Query /query/"+id);
        QueryItem queryItem = queryService.findItemById(id);
        logger.info("find item="+queryItem);
//        return new ResponseEntity<>(queryItem, HttpStatus.FOUND);
//        Branch branch = branchService.getOne(id);

//        if(queryItem == null) {
//            throw new Exception("Invalid item id : " + id);
//        }
        return queryItem;

//        return queryItem.toString();
    }
    @RequestMapping(value = "/saveItem")
    @ResponseStatus
    public ResponseEntity<QueryItem> saveItem(@RequestBody QueryItem queryItem) {
        queryService.addItem(queryItem);
        return new ResponseEntity<>(queryItem, HttpStatus.CREATED);
    }

    @RequestMapping(value = "addByParam", method= RequestMethod.GET)
    public ResponseEntity<QueryItem> saveItemByParam(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("context") String context) {
        QueryItem queryItem = new QueryItem(id, name, context);
        logger.info("start create record:"+queryItem);
        queryService.addItem(queryItem);
        logger.info("complete create record:"+queryItem);
        return new ResponseEntity<>(queryItem, HttpStatus.CREATED);
    }
}
