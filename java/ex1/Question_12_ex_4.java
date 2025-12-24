package ex1;

import java.util.Scanner;

public class Question_12_ex_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String str = scanner.nextLine();

        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }

        System.out.println("Chuỗi sau khi đảo ngược: " + reversed);

        scanner.close();

    }
}
