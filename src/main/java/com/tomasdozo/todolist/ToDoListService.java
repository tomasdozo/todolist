package com.tomasdozo.todolist;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoListService {
    private static final ToDoListService instance = new ToDoListService();

    private ToDoListService() {
    }

    public static ToDoListService getInstance (){
        return instance;
    }

    public List<ToDoItem> getList(){

        return ToDoListRepositoryLocal.getInstance().get();
    }

    public void add(ToDoItem item) {
        ToDoListRepositoryLocal.getInstance().add(item);
    }

    public boolean delete(int id) {
        return ToDoListRepositoryLocal.getInstance().remove(id);
    }

    public boolean check (int id, boolean done){
        ToDoItem aux=ToDoListRepositoryLocal.getInstance().search(id);
        if(aux!=null){
            aux.setDone(done);
            return ToDoListRepositoryLocal.getInstance().set(aux);
        }
        else{
            return false;
        }
    }

    public boolean modify (int id, String text){
        ToDoItem aux=ToDoListRepositoryLocal.getInstance().search(id);
        if(aux!=null){
            aux.setText(text);
            return ToDoListRepositoryLocal.getInstance().set(aux);
        }
        else{
            return false;
        }
    }
}
