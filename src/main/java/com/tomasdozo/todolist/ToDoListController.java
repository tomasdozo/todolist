package com.tomasdozo.todolist;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping ("/tareas")
public class ToDoListController {
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public List<ToDoItem> getToDoItems (){
        ToDoListService service=ToDoListService.getInstance();
        return service.getList();
    }

    @PostMapping
    public String addToDoItem (@RequestBody ToDoItem item){
        ToDoListService.getInstance().add(new ToDoItem(item.getText()));
        return "Success";
    }

    @PutMapping
    public String check (@RequestParam int id, @RequestParam boolean done){
        if(ToDoListService.getInstance().check(id,done)){
          return "Success"   ;
        }
        else{
            return "Not Found";
        }
    }

    @DeleteMapping ("/{id}")
    public String delToDoItem (@PathVariable int id){
       if(ToDoListService.getInstance().delete(id)){
           return "Success";
       }
       else{
           return "Not Found";
       }
    }

    @PutMapping ("/{id}")
    public String modToDoItem (@PathVariable int id, @RequestBody ToDoItem item){
        if(ToDoListService.getInstance().modify(id,item.getText())){
            return "Success"   ;
        }
        else{
            return "Not Found";
        }
    }





}
