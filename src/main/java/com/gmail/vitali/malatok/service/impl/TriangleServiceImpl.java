package com.gmail.vitali.malatok.service.impl;

import com.gmail.vitali.malatok.service.ShapeService;

public class TriangleServiceImpl implements ShapeService {
    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return ShapeService.super.getPerimeter();
    }

    @Override
    public void printInfo() {
        ShapeService.super.printInfo();
    }
}
