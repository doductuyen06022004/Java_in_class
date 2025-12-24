package ex1;

import java.util.Scanner;

public class Question_4_ex_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();

        for (int i = 0; i < name.length(); i++) {
            System.out.println("Ký tự thứ " + (i + 1) + " là: " + name.charAt(i));
        }

        scanner.close();
    }
}
