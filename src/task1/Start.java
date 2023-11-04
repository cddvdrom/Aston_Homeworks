package task1;


import task1.Entity.Cat;
import task1.Entity.Dog;
import task1.Entity.Pork;


public class Start {
    public static void main(String[] args) {
        Cat cat = new Cat("Барсик");
        cat.info();
        cat.run(10000);
        cat.swim(1);
        Dog dog = new Dog("Шарик");
        dog.info();
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
