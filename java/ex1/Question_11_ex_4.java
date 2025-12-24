package ex1;

import java.util.Scanner;

public class Question_11_ex_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                count++;
            }
        }

        System.out.println("Số lần xuất hiện ký tự 'a': " + count);

        scanner.close();
    }
}
