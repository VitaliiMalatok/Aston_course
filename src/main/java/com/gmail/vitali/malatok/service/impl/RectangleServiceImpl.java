package com.gmail.vitali.malatok.service.impl;

import com.gmail.vitali.malatok.service.ShapeService;

public class RectangleServiceImpl implements ShapeService {
    private double width, height;
    private String fillColor;
    private String borderColor;

    public RectangleServiceImpl(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void printInfo() {
        System.out.println("Rectangle - Width: " + width + ", Height: " + height);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println("Fill Color: " + fillColor);
        System.out.println("Border Color: " + borderColor);
        System.out.println("---------------------------");
    }
}
