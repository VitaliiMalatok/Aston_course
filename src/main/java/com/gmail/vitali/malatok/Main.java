package com.gmail.vitali.malatok;

public class Main {
    public static void main(String[] args) {
        //task_1
        printThreeWords("Orange", "Banana", "Apple");
        //task_2
        checkSumSign();
    }

    //task_1
    private static void printThreeWords(String firstWord, String secondWorld, String thirdWord){
        System.out.println(firstWord);
        System.out.println(secondWorld);
        System.out.println(thirdWord);
    }

    //task_2
    private static void checkSumSign() {
        int a = 1;
        int b = -1;
        int sum = a + b;
        if(sum >= 0){
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }
}