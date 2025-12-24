package ex1;

import java.util.Scanner;

public class Question_16_ex_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();

        System.out.print("Nhập n: ");
        int n = scanner.nextInt();

        // Kiểm tra điều kiện
        if (str == null || n <= 0 || str.length() % n != 0) {
            System.out.println("KO");
        } else {
            for (int i = 0; i < str.length(); i += n) {
                System.out.println(str.substring(i, i + n));
            }
        }

        scanner.close();
    }
}
