package ex1;

import java.util.Scanner;

public class Question_5_ex_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập họ: ");
        String ho = scanner.nextLine().trim();

        System.out.print("Nhập tên: ");
        String ten = scanner.nextLine().trim();

        String fullName = ho + " " + ten;

        System.out.println("Họ và tên đầy đủ: " + fullName);

        scanner.close();
    }
    }

