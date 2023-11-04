package task1.Factory;

import task1.Entity.Animal;
import task1.Entity.Cat;
import task1.Entity.Dog;
import task1.Validator.AnimalValidator;
import task1.Validator.AnimalValidatorImpl;

import java.util.Optional;

public class AnimalFactory {
    private final int MAX_CAT_RUN_DISTANCE = 100;
    private final int MAX_CAT_SWIM_DISTANCE = 0;
    private final int AMOUNT_CAT_FOR_FULL = 20;

    private final int MAX_DOG_RUN_DISTANCE = 200;
    private final int MAX_DOG_SWIM_DISTANCE = 50;
    private final int AMOUNT_DOG_FOR_FULL = 40;

    private AnimalValidator validator;

    public Animal createAnimal(AnymalType type, String name) {
        this.validator = new AnimalValidatorImpl();

        Animal animal = null;

        switch (type) {
            case CAT:
                animal = new Cat();
                animal.setAmountForFull(AMOUNT_CAT_FOR_FULL);
                animal.setMaxRunDistance(MAX_CAT_RUN_DISTANCE);
                animal.setMaxSwimDistance(MAX_CAT_SWIM_DISTANCE);
                animal.setName(name);
                break;
            case DOG:
                animal = new Dog();
                animal.setAmountForFull(AMOUNT_DOG_FOR_FULL);
                animal.setMaxRunDistance(MAX_DOG_RUN_DISTANCE);
                animal.setMaxSwimDistance(MAX_DOG_SWIM_DISTANCE);
                animal.setName(name);
                break;

        }

            if (validator.isValid(animal)) {
             return animal;
        }
return null;
    }
}
