package com.gmail.vitali.malatok;

public class Main {
    public static void main(String[] args) {
        //task_1
        printThreeWords("Orange", "Banana", "Apple");
        //task_2
        checkSumSign();
        //task_3
        printColor();
        //task_4
        compareNumbers();
        //task_5
        System.out.println(isSumNumber(10, 5));
        //task_6
        compareOfNumber(-5);
        //task_7
        System.out.println(isCompareOfNumber(0));
        //task_8
        printOfString(3, "Hello Aston_course");
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

    //task_4
    private static void compareNumbers() {
        int a = 1;
        int b = -1;
        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    //task_5
    private static boolean isSumNumber(int firstNumber, int secondNumber) {
        int result = firstNumber + secondNumber;
        if (result >= 10 && result <= 20) {
            return true;
        } else {
            return false;
        }
    }

    //task_6
    private static void compareOfNumber(int firstNumber) {
        if (firstNumber >= 0) {
            System.out.println( firstNumber + " число положительное");
        } else {
            System.out.println( firstNumber + " число отрицательное");
        }
    }

    //task_7
    private static boolean isCompareOfNumber(int firstNumber) {
        if (firstNumber < 0) {
            return true;
        } else {
            return false;
        }
    }

    //task_8
    private static void printOfString(int quantity, String basicString) {
        for (int i = 0; i < quantity; i++) {
            System.out.println(basicString);
        }
    }
}