package controller;
import java.util.Scanner;

import com.vti.backend.Exercise1Day6;
import com.vti.entity.Class;
import com.vti.entity.Student;

import java.util.Optional;

public class StudentController {


   public static void addInforStudent() {

       boolean result = false;
       Exercise1Day6.printStudentList();
       System.out.println("Chọn từ danh sách sinh vien đã có");

      String idStudents = Exercise1Day6.getString("nhap id student");
       idStudents = String.valueOf(Exercise1Day6.getStudentById());
       System.out.println(idStudents);
   }

}

