package com.gmail.vitali.malatok;

public class Dog extends Animal {
    private static int dogCount = 0;
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;

    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(int distance) {
        if (distance > MAX_RUN_DISTANCE) {
            System.out.println(name + " can't run more than " + MAX_RUN_DISTANCE + " m.");
        } else {
            super.run(distance);
        }
    }

    @Override
    public void swim(int distance) {
        if (distance > MAX_SWIM_DISTANCE) {
            System.out.println(name + " can't swim more than " + MAX_SWIM_DISTANCE + " m.");
        } else {
            super.swim(distance);
        }
    }

    public static int getDogCount() {
        return dogCount;
    }
}
