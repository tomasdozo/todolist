package com.tomasdozo.todolist;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class ToDoListController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping  ("/tareas")
    public List<ToDoItem> getToDoItems (){
        ToDoListService service=ToDoListService.getInstance();
        return service.getLista();
    }

    @PostMapping  ("/tareas")
    public String addToDoItem (@RequestParam String text){
        ToDoListService.getInstance().add(new ToDoItem(text));
        return "Success";
    }

    @PutMapping ("/tareas")
    public String check (@RequestParam int id, @RequestParam boolean done){
        if(ToDoListService.getInstance().check(id,done)){
          return "Success"   ;
        }
        else{
            return "Not Found";
        }
    }

    @DeleteMapping ("/tareas/{id}")
    public String delToDoItem (@PathVariable int id){
       if(ToDoListService.getInstance().delete(id)){
           return "Success";
       }
       else{
           return "Not Found";
       }
    }

    @PutMapping ("/tareas/{id}")
    public String modToDoItem (@PathVariable int id, @RequestParam String text){
        if(ToDoListService.getInstance().modify(id,text)){
            return "Success"   ;
        }
        else{
            return "Not Found";
        }
    }





}
