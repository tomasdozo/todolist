package com.tomasdozo.todolist;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ToDoListController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping ("/get")
    public List<ToDoItem> getMapping (){
        ToDoListService service=ToDoListService.getInstance();
        List<ToDoItem> l=service.getLista();
        return l;
    }



}
