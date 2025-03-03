package com.gmail.vitali.malatok.service;

public interface ShapeService {
    double getArea();

    default double getPerimeter() {
        return 0.0; // Значение по умолчанию
    }

    default void printInfo() {
        System.out.println("Shape Information");
    }
}
