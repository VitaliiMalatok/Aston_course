package com.gmail.vitali.malatok.service.impl;

import com.gmail.vitali.malatok.model.MyArrayDataException;
import com.gmail.vitali.malatok.model.MyArraySizeException;
import com.gmail.vitali.malatok.service.ArrayProcessor;

public class ArrayProcessorImpl implements ArrayProcessor {
    private static final int REQUIRED_SIZE = 4;

    @Override
    public int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != REQUIRED_SIZE || array[0].length != REQUIRED_SIZE) {
            throw new MyArraySizeException("Массив должен быть размером 4x4.");
        }

        int sum = 0;
        for (int i = 0; i < REQUIRED_SIZE; i++) {
            for (int j = 0; j < REQUIRED_SIZE; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в ячейке [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }
        return sum;
    }
}
