package ex1;

import java.util.Scanner;

public class Question_10_ex_4 {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         System.out.print("Nhập chuỗi thứ nhất: ");
         String s1 = scanner.nextLine();

         System.out.print("Nhập chuỗi thứ hai: ");
         String s2 = scanner.nextLine();

         // Đảo ngược chuỗi s1
         String reversed = new StringBuilder(s1).reverse().toString();

         if (reversed.equals(s2)) {
             System.out.println("OK");
         } else {
             System.out.println("KO");
         }

         scanner.close();
     }
     }

