package com.gmail.vitali.malatok.model;

public class Factorial {
    public static long calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
