package task1;


import task1.Entity.Animal;

import task1.Factory.AnimalFactory;
import task1.Factory.AnymalType;
import task1.View.ConsoleDisplay;
import task1.View.DisplayResult;


public class Start {
    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();
        DisplayResult display=new ConsoleDisplay();
        try {
            Animal dog = factory.createAnimal(AnymalType.DOG, "Шарик");
            System.out.println(dog.info());
            display.show(dog.run(-500));
            display.show(dog.swim(-500));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }
        try {
            Animal cat = factory.createAnimal(AnymalType.CAT, "Барсик");
            System.out.println(cat.info());
            display.show(cat.run(-500));
            display.show(cat.swim(-500));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }


    }
}
