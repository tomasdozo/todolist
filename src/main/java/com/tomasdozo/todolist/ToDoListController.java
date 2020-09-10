package com.tomasdozo.todolist;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping ("/tareas")
public class ToDoListController {

    @GetMapping
    public List<ToDoItem> getToDoItems (){
        ToDoListService service=ToDoListService.getInstance();
        return service.getList();
    }

    @PostMapping
    public ResponseEntity<String> addToDoItem (@RequestBody ToDoItem item){
        if(item.getText()!=null) {
            ToDoListService.getInstance().add(new ToDoItem(item.getText()));
            return new ResponseEntity<>("Item added succesfully",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Item not valid",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<String> check (@RequestParam int id, @RequestParam boolean done){
        if(ToDoListService.getInstance().check(id,done)){
            return new ResponseEntity<>("Succesfull",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Item not found",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<String> delToDoItem (@PathVariable int id){
       if(ToDoListService.getInstance().delete(id)){
           return new ResponseEntity<>("Item deleted succesfully",HttpStatus.OK);
       }
       else{
           return new ResponseEntity<>("Item not found",HttpStatus.NOT_FOUND);
       }
    }

    @PutMapping ("/{id}")
    public ResponseEntity<String> modToDoItem  (@PathVariable int id, @RequestBody ToDoItem item){
        if(ToDoListService.getInstance().modify(id,item.getText())){
            return new ResponseEntity<>("Item modified successfully",HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("Item not found",HttpStatus.NOT_FOUND);
        }
    }





}
