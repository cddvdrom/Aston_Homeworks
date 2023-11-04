package task1;

import task1.Entity.Animal;
import task1.Entity.Cat;
import task1.Entity.Dog;
import task1.Entity.Pork;

import java.util.ArrayList;

public class Start {
    public static void main(String[] args) {
        Cat cat = new Cat("Барсик");
        cat.run(10000);
        cat.swim(1);
        Dog dog = new Dog("Шарик");
        dog.run(6);
        dog.swim(5);

        Pork pork = new Pork();
        pork.printInfo();
        pork.addFood(500);
        pork.printInfo();
        cat.eat(pork);
        pork.printInfo();
        cat.info();

    }
}
