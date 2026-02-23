package com.vti.frontend;

import com.vti.backend.UserDao;
import com.vti.entity.User;

import java.util.Scanner;

public class Program1Day6 {
    public static void main(String[] args) {

        UserDao userDao = new UserDao();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Username: ");
                    String regUser = scanner.nextLine();

                    System.out.print("Password: ");
                    String regPass = scanner.nextLine();

                    if (userDao.register(regUser, regPass)) {
                        System.out.println("✅ Register success!");
                    } else {
                        System.out.println("❌ Register failed!");
                    }
                    break;

                case 2:
                    System.out.print("Username: ");
                    String loginUser = scanner.nextLine();

                    System.out.print("Password: ");
                    String loginPass = scanner.nextLine();

                    User user = userDao.login(loginUser, loginPass);

                    if (user != null) {
                        System.out.println("🎉 Login success! Welcome " + user.getUsername());
                        System.out.println("Your ID: " + user.getId());
                    } else {
                        System.out.println("❌ Wrong username or password!");
                    }
                    break;

                case 0:
                    System.out.println("Bye 👋");
                    return;
            }
        }

    }
}
