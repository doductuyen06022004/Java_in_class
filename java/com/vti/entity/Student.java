package com.vti.entity;



public class Student extends Person {

    public String getStudentId() {
        return studentId;
    }

    public EducationLevel getLevel() {
        return level;
    }
    public String setStudentId(){
        return studentId;
    }
    public EducationLevel setLevel(){
        return level;
    }

    private final String studentId;

    @Override
    public String toString() {
        return "Student{" +
                "level=" + level +
                ", studentId='" + studentId + '\'' +
                ", age=" + age +
                ", hometown='" + hometown + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    private final EducationLevel level;


    public Student(String name, int age, String hometown,
                   String studentId, EducationLevel level) {
        super(name, age, hometown);
        this.studentId = studentId;
        this.level = level;
    }

}
