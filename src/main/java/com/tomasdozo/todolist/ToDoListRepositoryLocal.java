package com.tomasdozo.todolist;

import java.util.ArrayList;

public class ToDoListRepositoryLocal extends ToDoListRepository {

    private final ArrayList<ToDoItem> datos;
    private static final ToDoListRepositoryLocal instance = new ToDoListRepositoryLocal();

    private ToDoListRepositoryLocal(){
        datos=new ArrayList<>();

        datos.add(new ToDoItem(0,"hacer shoppiong",true));
        datos.add(new ToDoItem(1,"hacer panaderia",false));
        datos.add(new ToDoItem(2,"comprar gaseosa",false));
        datos.add(new ToDoItem(3,"Papas",false));
        datos.add(new ToDoItem(4,"Soja",false));
        datos.add(new ToDoItem(5,"Harina",false));


    }

    public static ToDoListRepository getInstance (){
        return instance;
    }

    @Override
    public ToDoItem get(int index) {

        return datos.get(index);
    }

    @Override
    public void set(ToDoItem item) {
        datos.set(item.getIndex(), item);
    }

    @Override
    public void add(ToDoItem item) {
        item.setIndex(datos.size());
        datos.add(item);

    }

    @Override
    public void remove(ToDoItem item) {
        datos.remove(item.getIndex());

    }

    @Override
    public int size() {
        return datos.size();
    }
}
