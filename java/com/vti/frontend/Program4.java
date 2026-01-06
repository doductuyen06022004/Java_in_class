package com.vti.frontend;

import com.vti.entity.Account;
import com.vti.entity.Circle;
import com.vti.entity.Student;

import java.util.Date;

public class Program4 {
    public static void main(String[] args) {
        // Tạo student


        // Set điểm


        System.out.println("----------");

        // Cộng thêm điểm


        Circle c = new Circle(2.5, "blue");
        System.out.println(c);
        System.out.println("Area = " + c.getArea());

        Account a1 = new Account("A1", "Nguyen Van A", 1000);
        Account a2 = new Account("A2", "Tran Van B", 500);
        a1.transferTo(a2, 200);

        Date d = new Date(29, 2, 2024);
        System.out.println(d);
        System.out.println("Leap year: " + d.getYear());

    }
    }

