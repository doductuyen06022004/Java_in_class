package com.vti.entity;

public class Employee extends Staff {

    private String job;

    public Employee(String fullName, int age, Gender gender,
                    String address, String job) {
        super(fullName, age, gender, address);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Job: " + job);
    }
}
