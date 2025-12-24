package ex1;

import java.util.Scanner;

public class Question_2_ex_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập xâu s1: ");
        String s1 = scanner.nextLine();

        System.out.print("Nhập xâu s2: ");
        String s2 = scanner.nextLine();

        String result = s1 + s2;

        System.out.println("Xâu sau khi nối: " + result);

        scanner.close();
    }
}
