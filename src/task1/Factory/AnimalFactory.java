package task1.Factory;

import task1.Counter.AnimalCounter;
import task1.Entity.Animal;
import task1.Entity.Cat;
import task1.Entity.Dog;
import task1.Validator.AnimalValidator;


import static task1.Factory.AnimalType.CAT;
import static task1.Factory.AnimalType.DOG;


public class AnimalFactory {
    AnimalCounter counter;

    private AnimalValidator validator;

    public AnimalFactory() {
        this.counter = new AnimalCounter();
        this.validator = new AnimalValidator();

    }

    public Animal createAnimal(AnimalType type, String name) throws IllegalArgumentException {


        Animal animal = null;

        switch (type) {
            case CAT:
                animal = new Cat();
                animal.setAmountForFull(CAT.AMOUNT_FOR_FULL());
                animal.setMaxRunDistance(CAT.MAX_RUN_DISTANCE());
                animal.setMaxSwimDistance(CAT.MAX_SWIM_DISTANCE());
                animal.setName(name);
                animal.setGender("кот");
                break;
            case DOG:
                animal = new Dog();
                animal.setAmountForFull(DOG.AMOUNT_FOR_FULL());
                animal.setMaxRunDistance(DOG.MAX_RUN_DISTANCE());
                animal.setMaxSwimDistance(DOG.MAX_SWIM_DISTANCE());
                animal.setName(name);
                animal.setGender("собака");
                break;

        }

        if (validator.isValid(animal)) {
            counter.add(animal);
            return animal;
        } else {
            throw new IllegalArgumentException("Объект не создан. Ошибка входных данных ");

        }

    }

    public AnimalCounter getCounter() {
        return counter;
    }
}




