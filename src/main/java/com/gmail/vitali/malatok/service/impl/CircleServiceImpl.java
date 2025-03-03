package com.gmail.vitali.malatok.service.impl;

import com.gmail.vitali.malatok.service.ShapeService;

public class CircleServiceImpl implements ShapeService {
    private double radius;
    private String fillColor;
    private String borderColor;

    public CircleServiceImpl(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void printInfo() {
        System.out.println("Circle - Radius: " + radius);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("Fill Color: " + fillColor);
        System.out.println("Border Color: " + borderColor);
        System.out.println("---------------------------");
    }
}
