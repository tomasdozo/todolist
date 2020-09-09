package com.tomasdozo.todolist;

import java.io.Serializable;

public class ToDoItem implements Serializable {
    private int id;
    private String text;
    private Boolean done;
    private static final long serialVersionUID = 1;

    public ToDoItem(String text) {
        this.text = text;
        this.done = false;
        this.id = 0;
    }



    public ToDoItem() {
    }

    public ToDoItem(String text, int id, Boolean done) {
        this.text=text;
        this.id=id;
        this.done=done;
    }

    public int getId() {
        return id;
    }

    public void setId(int index) {
        this.id = index;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
