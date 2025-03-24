package com.gmail.vitali.malatok.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Factorial {
    public static final Logger logger = (Logger) LogManager.getLogger(Factorial.class);
    public static long calculate(int n) {
        if (n < 0) {
            logger.error("Factorial of negative number {} is not defined", n);
            throw new IllegalArgumentException("Number must be non-negative");
        }
        logger.info("Calculating factorial of {}", n);
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        logger.info("Factorial of {} is {}", n, result);
        return result;
    }
}
