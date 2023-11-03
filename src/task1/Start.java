package task1;

import task1.Entity.Animal;
import task1.Entity.Cat;
import task1.Entity.Dog;

import java.util.ArrayList;

public class Start {
    public static void main(String[] args) {
        Cat cat = new Cat("Барсик");
        cat.run(10000);
        cat.eat(1);
        cat.swim(1);
        Dog dog = new Dog("Шарик");
        dog.eat(1);
        dog.run(6);
        dog.swim(5);
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(cat);
        animals.add(dog);

    }
}
