package com.gmail.vitali.malatok.model;

public class Cat extends Animal {
    private static int catCount = 0;
    private static final int MAX_RUN_DISTANCE = 200;
    private boolean isFull;

    public Cat(String name) {
        super(name);
        catCount++;
        this.isFull = false;
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
        System.out.println(name + " can't swim!");
    }

    public boolean isFull() {
        return isFull;
    }

    public void eat(FoodBowl bowl, int foodAmount) {
        if (bowl.decreaseFood(foodAmount)) {
            isFull = true;
            System.out.println(name + " ate and is now full.");
        } else {
            System.out.println(name + " couldn't eat, not enough food.");
        }
    }

    public static int getCatCount() {
        return catCount;
    }
}
