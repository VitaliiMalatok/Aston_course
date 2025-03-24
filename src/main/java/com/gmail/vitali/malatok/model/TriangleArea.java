package com.gmail.vitali.malatok.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleArea {
    private static final Logger LOGGER = LogManager.getLogger(TriangleArea.class);

    public static double calculate(double a, double b, double c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            LOGGER.error("Invalid input: a = {}, b = {}, c = {}", a, b, c);
            throw new IllegalArgumentException("Sides must be positive");
        }
        LOGGER.info("Calculating area of triangle with a = {}, b = {}, c = {}", a, b, c);
        double s = (a + b + c) / 2;
        LOGGER.info("Triangle area is {}", s);
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
