package com.vti.backend;

import com.vti.entity.Student;

import java.math.BigDecimal;




public class Ecercise1Day8 {
    public static Student[] printStudent(){
         Student [] students = new Student[3];
          students[0] = new Student(0 ,"Nguyen Van a ") ;
        students[1] = new Student(1 ,"Nguyễn Văn B ") ;
        students[2] = new Student(2 ,"Nguyễn Văn B ") ;


        Student.setCollege("Đại học bách khoa\"");
        Student.setCollege(" Đại học công nghệ");


        Student.pay_into_a_fund(100);
        Student.pay_into_a_fund(100);
        Student.pay_into_a_fund(100);
        Student.withdrawing(50);
        Student.withdrawing(20);
        Student.withdrawing( 150);
        Student.pay_into_a_fund(50);
        Student.pay_into_a_fund(50);
        Student.pay_into_a_fund(50);
        System.out.println("Money Group: " + Student.withdrawing(Student.getMoneyGroup()));
        // dùng for để in
        for (int i = 0; i < students.length; i++) {
            System.out.println("Student " + i);
            System.out.println("ID: " + students[i].getId());
            System.out.println("Name: " + students[i].getName());
            System.out.println("College: " + Student.getCollege());
            System.out.println();
            System.out.println("-------------------");
        }
        return students;
    }

    }

