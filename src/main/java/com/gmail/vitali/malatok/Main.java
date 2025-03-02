package com.gmail.vitali.malatok;

public class Main {
    public static void main(String[] args) {
        //task_1
        Dog dog1 = new Dog("Stepan");
        Cat cat1 = new Cat("Persik");
        Cat cat2 = new Cat("Martin");

        dog1.run(300);
        dog1.swim(5);

        cat1.run(150);
        cat1.swim(10);

        FoodBowl bowl = new FoodBowl(20);
        bowl.displayFood();

        cat1.eat(bowl, 10);
        cat2.eat(bowl, 15);

        bowl.displayFood();

        System.out.println("Total animals: " + Animal.animalCount);
        System.out.println("Total dogs: " + Dog.getDogCount());
        System.out.println("Total cats: " + Cat.getCatCount());
    }
}
