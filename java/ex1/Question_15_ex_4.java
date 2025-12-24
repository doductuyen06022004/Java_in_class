package ex1;

import java.util.Scanner;

public class Question_15_ex_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();

        System.out.print("Nhập ký tự cần thay thế: ");
        char oldChar = scanner.next().charAt(0);

        System.out.print("Nhập ký tự mới: ");
        char newChar = scanner.next().charAt(0);

        String result = str.replace(oldChar, newChar);

        System.out.println("Chuỗi sau khi thay thế: " + result);

        scanner.close();
    }
}
