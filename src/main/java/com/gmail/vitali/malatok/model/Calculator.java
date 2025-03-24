package com.gmail.vitali.malatok.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Calculator {
    private static final Logger LOGGER = LogManager.getLogger(Calculator.class);

    public static int add(int a, int b) {
        LOGGER.info("Adding {} + {}", a, b);
        int result = a + b;
        LOGGER.info("Result: {}", result);
        return result;
    }

    public static int subtract(int a, int b) {
        LOGGER.info("Subtracting {} - {}", a, b);
        int result = a - b;
        LOGGER.info("Result: {}", result);
        return result;
    }

    public static int multiply(int a, int b) {
        LOGGER.info("Multiplying {} * {}", a, b);
        int result = a * b;
        LOGGER.info("Result: {}", result);
        return result;
    }

    public static double divide(int a, int b) {
        LOGGER.info("Dividing {} / {}", a, b);
        if (b == 0) {
            LOGGER.error("Attempted division by zero");
            throw new ArithmeticException("Cannot divide by zero");
        }
        double result = (double) a / b;
        LOGGER.info("Result: {}", result);
        return result;
    }
}