package com.vti.entity;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("deprecation")
        Date date = new Date(120, 4, 18);

        System.out.println(date);
        Student student = new Student("Nguyễn Văn A");
        System.out.println(student.getName());

        System.out.println("ID (cũ): " + student.getId());


        System.out.println("ID (mới): " + student.getIdWithPrefix());

        System.out.println("Tên: " + student.getName());


        CPU cpu = new CPU(1500.0);

        CPU.Processor processor = cpu.new Processor(8, "Intel");


        CPU.Ram ram = cpu.new Ram(16, "Kingston");

   
        System.out.println("Processor cache: " + processor.getCache());
        System.out.println("Ram clock speed: " + ram.getClockSpeed());
    }
}
