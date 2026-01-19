package com.vti.backend;

import com.vti.entity.Student;

import java.math.BigDecimal;




public class Ecercise1Day8 {
    public static Student[] printStudent(){
         Student [] students = new Student[3];



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

