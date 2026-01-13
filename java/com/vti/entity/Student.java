package com.vti.entity;




public class Student  {
    private final int id;
    private final String name ;
    private static int moneyGroup  ;
    private static int count = 0;
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


    public static int getMoneyGroup() {
        return  moneyGroup;
    }

    public static void setMoneyGroup(int moneyGroup) {
        Student.moneyGroup = moneyGroup;

    }


    public static void pay_into_a_fund(int moneyGroup ) {
        Student.moneyGroup += moneyGroup;

        System.out.println(  " long quỹ " + moneyGroup + "k");
    }
    public static int  withdrawing(int moneyGroup ) {
        Student.moneyGroup -= moneyGroup;
        System.out.println(  " lấy " + moneyGroup + "k");
        return moneyGroup;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Student(int id, String name ) {
        this.id = id;
        this.name = name;
        count++;
    }
    public static int getCount() {
        return count;
    }
    public static String getCollege() {
        return college;
    }

    public static void setCollege(String college) {
        Student.college = college;

    }

    private static String college;


    public static String college() {

        return college;
    }
}
