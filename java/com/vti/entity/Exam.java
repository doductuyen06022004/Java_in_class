package com.vti.entity;

import java.time.LocalDate;

public class Exam {
    private   int id;
    private    String code;
    private   String title;
    private   CategoryQuestion category;
    private  int duration;
    private   Account creator;
    private   LocalDate createDate;
    public CategoryQuestion getCategory() {
        return category;
    }

    public void setCategory(CategoryQuestion category) {
        this.category = category;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    public Exam(CategoryQuestion category, String code, LocalDate createDate, Account creator, int duration, int id, String title) {
        this.category = category;
        this.code = code;
        this.createDate = createDate;
        this.creator = creator;
        this.duration = duration;
        this.id = id;
        this.title = title;
    }


}
