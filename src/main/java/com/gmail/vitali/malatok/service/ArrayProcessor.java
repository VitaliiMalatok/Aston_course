package com.gmail.vitali.malatok.service;

import com.gmail.vitali.malatok.model.MyArrayDataException;
import com.gmail.vitali.malatok.model.MyArraySizeException;

public interface ArrayProcessor {
    int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException;
}

