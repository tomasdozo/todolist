package com.tomasdozo.todolist;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class ToDoListRepository {

    public abstract ToDoItem search(int id);
    public abstract boolean set (ToDoItem item);
    public abstract void add (ToDoItem item);
    public abstract boolean remove (int id);
    public abstract int size ();
    public abstract List<ToDoItem> get();
}
