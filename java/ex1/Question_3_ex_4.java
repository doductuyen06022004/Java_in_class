package ex1;

import java.util.Scanner;

public class Question_3_ex_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập tên: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Tên không hợp lệ!");
        } else {
            // Lấy ký tự đầu và phần còn lại
            char firstChar = name.charAt(0);

            // Nếu chữ cái đầu chưa viết hoa
            if (Character.isLowerCase(firstChar)) {
                name = Character.toUpperCase(firstChar) + name.substring(1);
            }

            System.out.println("Tên sau khi chuẩn hóa: " + name);
        }

        scanner.close();
    }
}
