package com.tomasdozo.todolist;

public class ReturnData {
    private long id;
    private String content;


    public ReturnData( long id, String content) {
        this.content=content;
        this.id=id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
