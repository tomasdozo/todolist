package com.tomasdozo.todolist;

public class ToDoItem {
    private int index;
    private String text;
    private Boolean done;

    public ToDoItem(String text, Boolean done) {
        this.text = text;
        this.done = done;
    }

    public ToDoItem() {
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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
