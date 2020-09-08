package com.tomasdozo.todolist;

import java.util.ArrayList;

public class LocalRepository extends ToDoListRepository {

    private ArrayList<ToDoItem> datos;
    private LocalRepository instance = new LocalRepository();

    private LocalRepository(){
        datos=new ArrayList<ToDoItem>();
    }

    public LocalRepository getInstance (){
        return instance;
    }
    @Override
    public ToDoItem get(int index) {

        return datos.get(index);
    }

    @Override
    public void set(ToDoItem item) {
        datos.set(item.getIndex(), item);
        return;
    }

    @Override
    public void add(ToDoItem item) {
        item.setIndex(datos.size());
        datos.add(item);
        return;

    }

    @Override
    public void remove(ToDoItem item) {
        datos.remove(item.getIndex());

    }
}
