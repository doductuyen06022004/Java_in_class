package com.vti.entity;



public class Person implements IRollUp {
    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String name;
    public int age;
}
