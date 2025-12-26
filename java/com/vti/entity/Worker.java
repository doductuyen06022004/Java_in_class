package com.vti.entity;

public class Worker extends Staff {

    private int level; // 1 → 10

    public Worker(String fullName, int age, Gender gender,
                  String address, int level) {
        super(fullName, age, gender, address);
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Level: " + level);
    }
}
