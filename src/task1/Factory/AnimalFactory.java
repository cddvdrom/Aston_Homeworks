package task1.Factory;

import task1.Entity.Animal;
import task1.Entity.Cat;
import task1.Entity.Dog;

public class AnimalFactory {

    public Animal createAnimal (AnymalType type,String name){
       Animal animal=null;

       switch (type){
           case CAT:
               animal=new Cat(name);
           break;
           case DOG:
               animal=new Dog(name);
               break;

       }
    return animal;
}}
