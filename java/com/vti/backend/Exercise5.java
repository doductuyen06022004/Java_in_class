package com.vti.backend;

import com.vti.entity.*;

public class Exercise5 {
    public static void question1() {
        Staff w = new Worker(
                "Nguyen Van A", 30, Gender.MALE, "Ha Noi", 5
        );

        Staff e = new Engineer(
                "Tran Thi B", 28, Gender.FEMALE, "Da Nang", "IT"
        );

        Staff emp = new Employee(
                "Le Van C", 35, Gender.UNKNOWN, "HCM", "Administration"
        );

        w.printInfo();
        System.out.println("----");
        e.printInfo();
        System.out.println("----");
        emp.printInfo();
    }
    public static void question2() {
    StaffManagement staffManagement = new StaffManagement();

      // staffManagement.addStaff();
       staffManagement.displayAllStaff();
       staffManagement.deleteByName("tuyen");
       staffManagement.displayAllStaff();
    }
}
