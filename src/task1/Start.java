package task1;


import task1.Entity.Animal;

import task1.Entity.Pork;
import task1.Factory.AnimalFactory;
import task1.Factory.AnymalType;
import task1.Factory.PorkFactory;
import task1.View.ConsoleDisplay;
import task1.View.DisplayResult;


public class Start {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        PorkFactory porkFactory= new PorkFactory();
        DisplayResult display = new ConsoleDisplay();
        try {
            Animal dog = animalFactory.createAnimal(AnymalType.DOG, "Шарик");
            display.show(dog.run(200));
            display.show(dog.swim(10));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            Animal cat = animalFactory.createAnimal(AnymalType.CAT, "Барсик");
            display.show(cat.run(100));
            display.show(cat.swim(1));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try{
            Pork pork=porkFactory.createPork(1000);
            pork.addFood(300);
            for (Animal animal:animalFactory.getCounter().getAnimals()
                 ) {
                System.out.println(animal.eat(pork).getMessage());

            }
        }
        catch (IllegalArgumentException e){System.out.println(e);}



    }
}
