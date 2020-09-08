package com.tomasdozo.todolist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoListService {
    private static final ToDoListService instance = new ToDoListService();

    private ToDoListService() {
    }

    public static ToDoListService getInstance (){
        return instance;
    }

    public List<ToDoItem> getLista(){
        ToDoListRepository repository = ToDoListRepositoryLocal.getInstance();
        List<ToDoItem> lista=new ArrayList<>();

        for (int i= repository.size()-1; i>=0; i--){
            lista.add(repository.get(i));
        }

        return lista;
    }
}
