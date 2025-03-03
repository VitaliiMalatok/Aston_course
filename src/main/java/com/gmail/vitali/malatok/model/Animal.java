package com.gmail.vitali.malatok.model;

public class Animal {
    protected final String name;
    public static int animalCount = 0;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public void run(int distance) {
        System.out.println(name + " ran " + distance + " m.");
    }

    public void swim(int distance) {
        System.out.println(name + " swam " + distance + " m.");
    }
}
