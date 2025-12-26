package com.vti.entity;

public class Engineer extends Staff {

    private String major;

    public Engineer(String fullName, int age, Gender gender,
                    String address, String major) {
        super(fullName, age, gender, address);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Major: " + major);
    }
}
