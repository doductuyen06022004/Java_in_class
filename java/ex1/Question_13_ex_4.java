package ex1;

import java.util.Scanner;

public class Question_13_ex_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();

        boolean result = true;

        // Kiểm tra null
        if (str == null) {
            result = false;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    result = false;
                    break;
                }
            }
        }

        System.out.println(result);

        scanner.close();
    }
}
