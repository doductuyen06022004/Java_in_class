package com.vti.entity;

public class Teacher extends Person {
    private String teacherId;
    private double salary;
    private String specialization;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public Teacher(String name, int age, String hometown, double salary, String specialization, String teacherId) {
        super(name, age, hometown);
        this.salary = salary;
        this.specialization = specialization;
        this.teacherId = teacherId;
    }


    public Teacher(String name, int age, String hometown, String teacherId, double salary, String specialization) {
        super(name, age, hometown);
        this.teacherId = teacherId;
        this.salary = salary;
        this.specialization = specialization;
    }

    public void teach() {
        System.out.println(name + " is teaching...");
    }

}

