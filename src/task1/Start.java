package task1;


import task1.Entity.Animal;

import task1.Factory.AnimalFactory;
import task1.Factory.AnymalType;


public class Start {
    public static void main(String[] args) {
        AnimalFactory factory=new AnimalFactory();
        Animal dog=factory.createAnimal(AnymalType.DOG,"Шарик");
        Animal cat=factory.createAnimal(AnymalType.CAT,"Барсик");
        System.out.println(cat.info());
        System.out.println(dog.info());

    }
}
