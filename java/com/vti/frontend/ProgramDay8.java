package com.vti.frontend;

import com.vti.backend.*;
import com.vti.entity.Student;
import com.vti.entity.User;

public class ProgramDay8 {
    public static void main(String[] args) {
        Ecercise1Day8.printStudent();
        int result  = MyMath.max(10,7);
        int result1 = MyMath.min(10,7);
        int result2 = MyMath.sum(10,7);
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println("Số Student được sinh ra: " + Student.getCount());
        SecondaryStudent secondaryStudent = new SecondaryStudent();
        SecondaryStudent secondaryStudent2 = new SecondaryStudent();
        SecondaryStudent secondaryStudent1 = new SecondaryStudent();
        SecondaryStudent secondaryStudent4 = new SecondaryStudent();
        SecondaryStudent secondaryStudent5 = new SecondaryStudent();
        SecondaryStudent secondaryStudent3 = new SecondaryStudent();
        SecondaryStudent secondaryStudent6 = new SecondaryStudent();
        PrimaryStudent primaryStudent = new PrimaryStudent();
        PrimaryStudent primaryStudent2 = new PrimaryStudent();

        System.out.println("Số PrimaryStudent được sinh ra: " + PrimaryStudent.getIdPrimaryStudent());
        System.out.println("Số SecondaryStudent được sinh ra: " + SecondaryStudent.getIdSecondaryStudent());

        User user = new User("admin");

        for (int i = 1; i <= 8; i++) {
            Student student = new Student(1, "Student " + i);
            user.addStudent(student);
        }

        user.showStudents();
        MyMath.sum1(2);
        System.out.println(MyMath.sum1(2));
        try {
            Geometry Circle1 = new Circle(6);
            Geometry Circle2 = new Circle(4);
            Geometry Circle3 = new Circle(2);
            Geometry Circle4 = new Circle(8);
            Geometry Rectangle = new Rectangle(5, 3);
            Geometry Rectangle1 = new Rectangle(4, 9);
        } catch (GeometryException e) {
            throw new RuntimeException(e);
        }

    }
}
