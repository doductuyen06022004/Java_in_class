package com.vti.backend;

import java.util.Scanner;

public class Exercise2Day7 {
    public static void question_1(){
        try {
            float r = divide(7, 0);

        }
         catch (ArithmeticException e){
            System.out.println("cannot divide 0");
        } finally
        {
            System.out.println("divide completed!"); //question 2
        }

    }
    public static int divide(int a, int b){
        return a/b;
    }
    public static void question_3( ) {

        try {  int[] numbers = {1,2,3};
            System.out.println(numbers[14]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException");
        }
    }
    public static void getIndex(int index) {
        try {  int[] departments  = {1,2,3};
        System.out.println(departments [index]);}
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Cannot find department");
        }
    }
    public static int inputAge () {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Please input your age: ");
            String input = scanner.nextLine();

            try {
                int age = Integer.parseInt(input);
                return age;
            } catch (NumberFormatException e) {
                System.out.println(
                        "wrong inputing! Please input an age as int, input again."
                );
            }
        }

    }

}
