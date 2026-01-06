package com.vti.backend;

import com.vti.entity.Student;


import java.util.Objects;
import java.util.Optional;
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
    }
    public static Optional<Student> getStudentById() {
        Student student = new Student("", 0, "", "", null);
        String idStudent = "";
        do {
            idStudent = getString(idStudent);
        } while (Objects.isNull(idStudent));
        for (int i = 0; i <= students.length - 1; i++) {
            if (students[i] != null) {
                if (students[i].getStudentId().equals(idStudent)) {
                    student.setName(students[i].getName());
                    student.setAge(students[i].getAge());
                    student.setHometown(students[i].getHometown());
                    student.setLevel();


                }

            } else {
                break;
            }
            return Optional.of(students[i]);
        } return Optional.of(student);
    }
}
