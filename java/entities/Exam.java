package entities;

import java.time.LocalDate;

public class Exam {
    public  int id;
    public   String code;
    public  String title;

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

    public  CategoryQuestion category;
    public int duration;
    public  Account creator;
    public  LocalDate createDate;

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
