package com.tomasdozo.todolist;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ToDoListController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping  ("/tareas")
    public List<ToDoItem> getMapping (){
        ToDoListService service=ToDoListService.getInstance();
        return service.getLista();
    }

    @PostMapping  ("/tareas")
    public void postMapping (@RequestParam String text){
        ToDoListService.getInstance().add(new ToDoItem(text));
    }

    @DeleteMapping ("/tareas")
    public String deleteMapping (@RequestParam int id){
        //ToDoListService.getInstance().delete(Integer.getInteger(id));
       if(ToDoListService.getInstance().delete(id)){
           return "Sucess";
       }
       else{
           return "Not Found";
       }
    }





}
