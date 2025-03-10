package com.gmail.vitali.malatok.service.impl;

import com.gmail.vitali.malatok.service.ArrayProcessor;
import com.gmail.vitali.malatok.service.RunTaskService;

public class RunTaskServiceImpl implements RunTaskService {
    @Override
    public void runTaskService() {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "X", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        ArrayProcessor processor = new ArrayProcessorImpl();

        try {
            int result = processor.processArray(correctArray);
            System.out.println("Сумма элементов: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            processor.processArray(wrongSizeArray);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            processor.processArray(wrongDataArray);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Генерация ArrayIndexOutOfBoundsException
        try {
            String value = correctArray[4][0]; // Неверный индекс
            System.out.println(value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
