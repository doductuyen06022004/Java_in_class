package com.vti.backend;


import java.util.Scanner;

public class ScannerUtils {

    public static int inputInt(String errorMessage) {

        Scanner scanner = new Scanner(System.in);

            while (true) {
                try {
                    return Integer.parseInt( scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println(errorMessage);
                }
            }

        }
    public static float inputFloat(String errorMessage) {
        while (true) {
            try {
                Scanner scanner = null;
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }

    public static double inputDouble(String errorMessage) {
        while (true) {
            try {
                Scanner scanner = null;
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(errorMessage);
            }
        }
    }

    public static String inputString() {
        Scanner scanner = null;
        return scanner.nextLine();
    }
    }