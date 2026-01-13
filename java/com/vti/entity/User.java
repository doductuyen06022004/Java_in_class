package com.vti.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private List<Student> students;

    private static final int MAX_STUDENT = 7;

    public User(String username) {
        this.username = username;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (students.size() >= MAX_STUDENT) {
            System.out.println(" User chỉ được tạo tối đa 7 học sinh!");
            return;
        }
        students.add(student);
        System.out.println(" Đã thêm học sinh: " + student.getName());
    }

    public void showStudents() {
        System.out.println("Danh sách học sinh của user " + username + ":");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }
}
