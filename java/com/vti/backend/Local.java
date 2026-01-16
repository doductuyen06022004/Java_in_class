package com.vti.backend;

import java.text.NumberFormat;
import java.util.Locale;

public class Local {
    public static void main(String[] args) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance(Locale.GERMAN);
        System.out.println(formatter.format(100.0));

    }
}
