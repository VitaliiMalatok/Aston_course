package com.gmail.vitali.malatok.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Factorial {
    public static final Logger LOGGER = LogManager.getLogger(Factorial.class);

    public static long calculate(int n) {
        if (n < 0) {
            LOGGER.error("Factorial of negative number {} is not defined", n);
            throw new IllegalArgumentException("Number must be non-negative");
        }
        LOGGER.info("Calculating factorial of {}", n);
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        LOGGER.info("Factorial of {} is {}", n, result);
        return result;
    }
}
