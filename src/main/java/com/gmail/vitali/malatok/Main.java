package com.gmail.vitali.malatok;

import com.gmail.vitali.malatok.model.Animal;
import com.gmail.vitali.malatok.model.Cat;
import com.gmail.vitali.malatok.model.Dog;
import com.gmail.vitali.malatok.model.FoodBowl;
import com.gmail.vitali.malatok.service.ShapeService;
import com.gmail.vitali.malatok.service.impl.CircleServiceImpl;
import com.gmail.vitali.malatok.service.impl.RectangleServiceImpl;
import com.gmail.vitali.malatok.service.impl.TriangleServiceImpl;

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

        //task_2
        ShapeService[] shapes = {
                new CircleServiceImpl(5, "Blue", "Black"),
                new RectangleServiceImpl(4, 6, "Green", "Red"),
                new TriangleServiceImpl(3, 4, 5, "Yellow", "Purple")
        };
        for (ShapeService shape : shapes) {
            shape.printInfo();
        }
    }
}
