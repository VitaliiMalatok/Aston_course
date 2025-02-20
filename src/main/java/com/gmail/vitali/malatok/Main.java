package com.gmail.vitali.malatok;

public class Main {
    public static void main(String[] args) {
        //task_1
        printThreeWords("Orange", "Banana", "Apple");
        //task_2
        checkSumSign();
        //task_3
        printColor();
    }

    //task_1
    private static void printThreeWords(String firstWord, String secondWorld, String thirdWord) {
        System.out.println(firstWord);
        System.out.println(secondWorld);
        System.out.println(thirdWord);
    }

    //task_2
    private static void checkSumSign() {
        int a = 1;
        int b = -1;
        int sum = a + b;
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    //task_3
    private static void printColor() {
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 && value <= 100) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
    }
}