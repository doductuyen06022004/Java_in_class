package com.vti.backend;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Group;
import com.vti.entity.Position;

import java.time.LocalDate;

public class Exercise1 {

    // Question 1
    public static void question1() {

        Department dep1 = new Department(1, "IT");
        Department dep2 = new Department(2, "Sale");

        System.out.println("Department 1: id = " + dep1.getId() + ", name = " + dep1.getName());
        System.out.println("Department 2: id = " + dep2.getId() + ", name = " + dep2.getName());
    }
    public static void question2() {

        // a) Không có parameters
        Account acc1 = new Account();

        // b) Có id, email, username, firstname, lastname
        Account acc2 = new Account(
                1,
                "a@gmail.com",
                "user1",
                "Nguyen",
                "An"
        );

        // c) Có position, createDate = now
        Account acc3 = new Account(
                2,
                "b@gmail.com",
                "user2",
                "Tran",
                "Binh",
                Position.DEV
        );

        // d) Có position và createDate
        Account acc4 = new Account(
                3,
                "c@gmail.com",
                "user3",
                "Le",
                "Cuong",
                Position.MANAGER,
                LocalDate.of(2024, 1, 1)
        );
    } public static void question3() {

        Account creator = new Account(
                1,
                "admin@gmail.com",
                "admin",
                "Nguyen",
                "Admin",
                Position.MANAGER
        );

        // a) Không parameters
        Group group1 = new Group();

        // b) Account[]
        Account acc1 = new Account(2, "a@gmail.com", "user1", "Tran", "An");
        Account acc2 = new Account(3, "b@gmail.com", "user2", "Le", "Binh");

        Group group2 = new Group(
                "Java Fresher",
                creator,
                new Account[]{acc1, acc2},
                LocalDate.now()
        );

        // c) usernames[]
        Group group3 = new Group(
                "Backend Team",
                creator,
                new String[]{"user3", "user4"},
                LocalDate.of(2024, 1, 1)
        );
    }

    public static void main(String[] args) {
        int [] number = {-1 , 1 ,3,5,-5,-8, -20 ,-18, -25};
        int maxValue = getMaxValue (number);
        int minValue = getMinvalue (number );
        System.out.println("maxValue = " + maxValue);
        System.out.println("minValue = " + minValue);
    }
    public static int getMaxValue (int[] number) {
        int max = number[0];
        for (int i = 1; i < number.length; i++) {// i=3
            if (number[i] > max) {
                max = number[i];
            }
        }return max;
    }
    public static int getMinvalue (int[] number) {
        int min = number[0];
        for (int i = 1; i < number.length ; ++i) {
            if (number[i] < min) {
                min = number[i];
            }
        }return min;
    }
}
