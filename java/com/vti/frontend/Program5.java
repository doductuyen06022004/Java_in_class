package com.vti.frontend;

import com.vti.backend.Exercise5;
import com.vti.backend.StaffManagement;
import com.vti.entity.Employee;
import com.vti.entity.Engineer;
import com.vti.entity.Gender;
import com.vti.entity.Worker;


import java.util.Scanner;

import static com.vti.backend.Exercise1.question1;
import static com.vti.backend.Exercise1.question2;


public class Program5 {
    public static void main(String[] args) {
        Exercise5.question1();
        question1();
        Exercise5.question2();


        Scanner scanner = new Scanner(System.in);
        StaffManagement manager = new StaffManagement();

        while (true) {
            System.out.println("\n===== STAFF MANAGEMENT =====");
            System.out.println("1. Add new staff");
            System.out.println("2. Search staff by name");
            System.out.println("3. Display all staff");
            System.out.println("4. Delete staff by name");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.println("Choose staff type:");
                    System.out.println("1. Worker");
                    System.out.println("2. Engineer");
                    System.out.println("3. Employee");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Full name: ");
                    String name = scanner.nextLine();

                    System.out.print("Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Gender (MALE/FEMALE/OTHER): ");
                    Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());

                    System.out.print("Address: ");
                    String address = scanner.nextLine();

                    if (type == 1) {
                        System.out.print("Level (1-10): ");
                        int level = scanner.nextInt();
                        manager.addStaff(new Worker(name, age, gender, address, level));
                    } else if (type == 2) {
                        System.out.print("Major: ");
                        String major = scanner.nextLine();
                        manager.addStaff(new Engineer(name, age, gender, address, major));
                    } else if (type == 3) {
                        System.out.print("Job: ");
                        String job = scanner.nextLine();
                        manager.addStaff(new Employee(name, age, gender, address, job));
                    }
                    break;

                case 2:
                    System.out.print("Enter name to search: ");
                    manager.searchByName(scanner.nextLine());
                    break;

                case 3:
                    manager.displayAllStaff();
                    break;

                case 4:
                    System.out.print("Enter name to delete: ");
                    manager.deleteByName(scanner.nextLine());
                    break;

                case 5:
                    System.out.println("Exit program.");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    }

