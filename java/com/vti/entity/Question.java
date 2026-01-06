package com.vti.entity;



import java.time.LocalDate;

public class Question {
    private  int id;
    private  String content;
    private  CategoryQuestion category;
 //   private  TypeQuestion type;
    private  Account creator;
    private  LocalDate createDate;
  /*  public TypeQuestion getType() {
        return type;
    }

    public void setType(TypeQuestion type) {
        this.type = type;
    }
*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CategoryQuestion getCategory() {
        return category;
    }

    public void setCategory(CategoryQuestion category) {
        this.category = category;
    }



    public Question(CategoryQuestion category, String content, LocalDate createDate, Account creator, int id) {
        this.category = category;
        this.content = content;
        this.createDate = createDate;
        this.creator = creator;
        this.id = id;
     //   this.type = type;
    }


}
