package com.vti.frontend;

import com.vti.backend.DepartmentDao;
import com.vti.entity.Department;

import java.util.List;
import java.util.Scanner;

public class ProgramDay10 {

    public static void main(String[] args) {

        DepartmentDao departmentDao = new DepartmentDao();
        Scanner scanner = new Scanner(System.in);

        try {
            // Question 1
            System.out.println("=== LIST DEPARTMENTS ===");
            List<Department> departments = departmentDao.getDepartments();
            departments.forEach(System.out::println);

            // Question 3
            System.out.print("\nEnter department id: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Department department = departmentDao.getDepartmentById(id);
            System.out.println(department);

            // Question 4
            System.out.print("\nEnter department name to check: ");
            String checkName = scanner.nextLine();
            System.out.println(
                    departmentDao.isDepartmentNameExists(checkName)
                            ? "Department name exists"
                            : "Department name does not exist"
            );

            // Question 5
            System.out.print("\nEnter department name to create: ");
            String newName = scanner.nextLine();
            departmentDao.createDepartment(newName);
            System.out.println("Create department success!");

            // Question 6
            System.out.print("\nEnter department id to update: ");
            int updateId = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Enter new department name: ");
            String newName1 = scanner.nextLine();

            departmentDao.updateDepartmentName(updateId, newName1);
            System.out.println("Update department success!");

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
