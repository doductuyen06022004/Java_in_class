package com.vti.entity;

import static com.vti.entity.EducationLevel.COLLEGE;
import static com.vti.entity.EducationLevel.UNIVERSITY;

public class Class {
    public static Student[] students=new Student[20];
    static {
         Student students = new Student( "tuyen", 0,"ha noi ", "1",UNIVERSITY );
         Student student1 = new Student( "tuyen", 0,"ha noi ", "1",COLLEGE);
         Student student2 = new Student( "tuyen", 0,"ha noi ", "1",UNIVERSITY);

    Class.students[0] = students;
    Class.students[1] = student1;
    Class.students[2] = student2;
}
}

