package com.gmail.vitali.malatok.model;

public class NumberComparator {
    public static String compare(int a, int b) {
        if (a > b) {
            return "First number is greater";
        } else if (a < b) {
            return "Second number is greater";
        } else {
            return "Numbers are equal";
        }
    }
}
