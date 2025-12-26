package com.vti.entity;

public class CategoryQuestion {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CategoryQuestion(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private  int id;
    private   String name;
}
