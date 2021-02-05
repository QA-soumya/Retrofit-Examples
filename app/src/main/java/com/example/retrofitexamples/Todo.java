package com.example.retrofitexamples;

public class Todo {
    //https://run.mocky.io/v3/1d37a24d-e8c9-4444-a514-38532300a0b9
    private Integer id;
    private int userId;
    private String title;
    private Boolean completed;

    public Todo(int id,int userId,String title,Boolean completed){
        this.id=id;
        this.userId=userId;
        this.title=title;
        this.completed=completed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
