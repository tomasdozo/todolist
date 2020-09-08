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
        ArrayList<ToDoItem> aux= new ArrayList<>();
        ToDoItem item=new ToDoItem();
        item.setIndex(0);item.setDone(false);item.setText("Cocinar cena");
        aux.add(item);
        item=new ToDoItem();
        item.setIndex(1);item.setDone(false);item.setText("Shopping");
        aux.add(item);
        item=new ToDoItem();
        item.setIndex(2);item.setDone(false);item.setText("Comprar patata");
        aux.add(item);
        return aux;
    }



}
