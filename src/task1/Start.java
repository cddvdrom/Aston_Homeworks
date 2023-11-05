package task1;


import task1.Entity.Animal;

import task1.Entity.Pork;
import task1.Factory.AnimalFactory;
import task1.Factory.AnimalType;
import task1.Factory.PorkFactory;
import task1.View.Display;
import task1.View.DisplayLoader;


public class Start {
    public static void main(String[] args) {
        AnimalFactory animalFactory = new AnimalFactory();
        PorkFactory porkFactory= new PorkFactory();
        DisplayLoader loader=new DisplayLoader();
        Display display = loader.load();

        try {
            Animal dog = animalFactory.createAnimal(AnimalType.DOG, "Шарик");
            display.show(dog.run(200));
            display.show(dog.swim(10));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        try {
            Animal cat = animalFactory.createAnimal(AnimalType.CAT, "Барсик");
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
