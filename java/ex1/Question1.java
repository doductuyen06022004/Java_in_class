package ex1;

import entities.Account;

import java.time.LocalDate;

public class Question1 {
    public static void main(String[] args) {

        // Khai báo array Account có 5 phần tử
        Account[] accounts = new Account[5];

        // Dùng vòng for để khởi tạo dữ liệu
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account();
            accounts[i].email = "Email " + (i + 1);
            accounts[i].username = "User name " + (i + 1);
            accounts[i].fullName = "Full name " + (i + 1);
            accounts[i].createDate = LocalDate.now();
        }

        // In ra để kiểm tra
        for (Account acc : accounts) {
            System.out.println(
                    acc.email + " | " +
                            acc.username + " | " +
                            acc.fullName + " | " +
                            acc.createDate
            );
        }
    }
}
