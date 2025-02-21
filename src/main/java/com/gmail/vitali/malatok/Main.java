package com.gmail.vitali.malatok;

import java.util.Arrays;

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
        //task_9
        printOfYears();
        //task_10
        printArray();
        //task_11
        createArray();
        //task_12
        modifyArray();
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
            System.out.println(firstNumber + " число положительное");
        } else {
            System.out.println(firstNumber + " число отрицательное");
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

    //task_9
    private static boolean isYearsOfLeap() {
        int interYourYears = 2028;
        System.out.print(interYourYears);
        if (interYourYears % 400 == 0) {
            return true;
        } else if (interYourYears % 100 == 0) {
            return false;
        } else if (interYourYears % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    private static void printOfYears() {
        if (isYearsOfLeap() == true) {
            System.out.println(" - this year is a leap year");
        } else {
            System.out.println(" - this year is a non leap year");
        }
    }

    //task_10
    private static void printArray() {
        int[] simpleArray = {1, 1, 1, 1, 1, 0, 0, 0, 0, 0};
        System.out.println("basic array " + Arrays.toString(simpleArray));
        int counte = simpleArray.length;
        for (int i = 0; i < counte; i++) {
            if (simpleArray[i] == 0) {
                simpleArray[i] = 1;
            } else {
                simpleArray[i] = 0;
            }
        }
        System.out.println("new array after change " + Arrays.toString(simpleArray));
    }

    //task_11
    private static void createArray() {
        int[] basicArray = new int[100];
        for (int i = 0; i < basicArray.length; i++) {
            basicArray[i] = i + 1;
        }
        System.out.println("new array from 1 to 100 :" + Arrays.toString(basicArray));
    }

    //task_12
    private static void modifyArray() {
        int[] basicArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("basic array: " + Arrays.toString(basicArray));
        for (int i = 0; i < basicArray.length; i++) {
            if (basicArray[i] < 6) {
                basicArray[i] *= 2; //
            }
        }
        System.out.println("array after modify: " + Arrays.toString(basicArray));
    }
}