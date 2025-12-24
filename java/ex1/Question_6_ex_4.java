package ex1;

import java.util.Scanner;

public class Question_6_ex_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập họ và tên đầy đủ: ");
        String fullName = scanner.nextLine().trim();

        // Tách theo 1 hoặc nhiều khoảng trắng
        String[] words = fullName.split("\\s+");

        if (words.length < 2) {
            System.out.println("Vui lòng nhập đầy đủ họ và tên!");
        } else {
            // Họ
            System.out.println("Họ là: " + words[0]);

            // Tên
            System.out.println("Tên là: " + words[words.length - 1]);

            // Tên đệm
            if (words.length > 2) {
                StringBuilder middleName = new StringBuilder();
                for (int i = 1; i < words.length - 1; i++) {
                    middleName.append(words[i]).append(" ");
                }
                System.out.println("Tên đệm là: " + middleName.toString().trim());
            } else {
                System.out.println("Tên đệm là: Không có");
            }
        }

        scanner.close();
    }
    }

