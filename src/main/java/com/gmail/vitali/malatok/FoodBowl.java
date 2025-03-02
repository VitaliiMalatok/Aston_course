package com.gmail.vitali.malatok;

public class FoodBowl {
    private int foodAmount;

    public FoodBowl(int initialFood) {
        this.foodAmount = Math.max(initialFood, 0);
    }

    public boolean decreaseFood(int amount) {
        if (foodAmount >= amount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("Added " + amount + " units of food. Total: " + foodAmount);
        }
    }

    public void displayFood() {
        System.out.println("Current food in bowl: " + foodAmount);
    }
}
