package com.gmail.vitali.malatok.service.impl;

import com.gmail.vitali.malatok.service.ShapeService;

public class TriangleServiceImpl implements ShapeService {
    private double sideA, sideB, sideC;
    private String fillColor;
    private String borderColor;

    public TriangleServiceImpl(double sideA, double sideB, double sideC, String fillColor, String borderColor) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getArea() {
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public void printInfo() {
        System.out.println("Triangle - Sides: " + sideA + ", " + sideB + ", " + sideC);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("Fill Color: " + fillColor);
        System.out.println("Border Color: " + borderColor);
        System.out.println("---------------------------");
    }
}
