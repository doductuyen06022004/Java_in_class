package ex1;

import java.util.Scanner;

public class Question_7_ex_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập họ và tên đầy đủ: ");
        String fullName = scanner.nextLine();

        // a) Xóa khoảng trắng đầu, cuối và giữa
        fullName = fullName.trim();
        String[] words = fullName.split("\\s+");

        // b) Viết hoa chữ cái đầu mỗi từ
        StringBuilder normalizedName = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                String capitalized =
                        Character.toUpperCase(word.charAt(0)) +
                                word.substring(1).toLowerCase();
                normalizedName.append(capitalized).append(" ");
            }
        }

        System.out.println("Họ và tên sau khi chuẩn hóa: "
                + normalizedName.toString().trim());

        scanner.close();
    }
    }

