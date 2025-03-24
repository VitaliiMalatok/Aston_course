package com.gmail.vitali.malatok.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NumberComparator {
    private static final Logger LOGGER = LogManager.getLogger(NumberComparator.class);

    public static int compare(int a, int b) {
        LOGGER.info("Comparing numbers: {} and {}", a, b);
        int result = Integer.compare(a, b);
        if (result < 0) {
            LOGGER.info("{} is less than {}", a, b);
        } else if (result > 0) {
            LOGGER.info("{} is greater than {}", a, b);
        } else {
            LOGGER.info("{} is equal to {}", a, b);
        }
        return result;
    }
}