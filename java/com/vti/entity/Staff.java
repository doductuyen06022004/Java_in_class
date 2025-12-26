package com.vti.entity;

public class Staff {

    private String fullName;
    private int age;
    private Gender gender;
    private String address;

    public Staff(String fullName, int age, Gender gender, String address) {
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public void printInfo() {
        System.out.println(
                "Full name: " + fullName +
                        ", Age: " + age +
                        ", Gender: " + gender +
                        ", Address: " + address
        );
    }
}
