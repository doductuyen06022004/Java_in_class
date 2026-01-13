package com.vti.backend;

import com.vti.entity.Student;


import java.util.Objects;

import java.util.Scanner;

import static com.vti.entity.Class.students;
import static com.vti.entity.EducationLevel.COLLEGE;


public class Exercise1Day6 {
    public static void printStudentList() {
        for (int i = 0; i < students.length; i++) {
            if (Objects.nonNull(students[i])) {
                System.out.println(students[i]);
            } else {
                break;
            }
        }

    }
    public static String getString(String ask) {
        boolean isAskAgain = true;
        String userStringInput = "";
        while (isAskAgain) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println(ask);
                userStringInput = sc.nextLine();
                isAskAgain = false;
            } catch (Exception e) {
                System.out.println("Bạn phải nhập một đoạn văn bản");
            }

        }
        return userStringInput;
    }}
