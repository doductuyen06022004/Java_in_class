package ex1;

import java.util.Scanner;

public class Question_1_ex_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập xâu ký tự: ");
        String str = scanner.nextLine();

        // Loại bỏ khoảng trắng đầu cuối
        str = str.trim();

        // Nếu chuỗi rỗng sau khi trim
        if (str.isEmpty()) {
            System.out.println("Số từ trong xâu: 0");
        } else {
            // Tách theo 1 hoặc nhiều khoảng trắng
            String[] words = str.split("\\s+");
            System.out.println("Số từ trong xâu: " + words.length);
        }

        scanner.close();
    }
}
