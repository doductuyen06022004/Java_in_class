package com.vti.entity;

public class Student extends Person {

    private int id;

    private float score;
    public String clazz;
    private float fee;
    // b) Constructor: nhập name, hometown, score = 0
    public Student(String name, String age) {
        super(Integer.parseInt(name),age  );
       this.fee = fee;
    }

    // c) Set điểm
    public void setScore(float score) {
        this.score = score;
    }

    // d) Cộng thêm điểm
    public void addScore(float score) {
        this.score += score;
    }

    // e) In thông tin + xếp loại
    public void printInfo() {
        String rank;

        if (score < 4.0) {
            rank = "Yếu";
        } else if (score < 6.0) {
            rank = "Trung bình";
        } else if (score < 8.0) {
            rank = "Khá";
        } else {
            rank = "Giỏi";
        }

        System.out.println("Tên: " + name);
        System.out.println("Điểm học lực: " + score);
        System.out.println("Xếp loại: " + rank);
    }
}
