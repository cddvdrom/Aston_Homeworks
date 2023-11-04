package task1.Factory;

import task1.Entity.Animal;
import task1.Entity.Cat;
import task1.Entity.Dog;
import task1.Result.Result;
import task1.Validator.AnimalValidator;
import task1.Validator.AnimalValidatorImpl;

import java.util.ArrayList;


public class AnimalFactory {

    private ArrayList<Animal> animals;
    private final int MAX_CAT_RUN_DISTANCE = 200;
    private final int MAX_CAT_SWIM_DISTANCE = 0;
    private final int AMOUNT_CAT_FOR_FULL = 20;

    private final int MAX_DOG_RUN_DISTANCE = 500;
    private final int MAX_DOG_SWIM_DISTANCE = 10;
    private final int AMOUNT_DOG_FOR_FULL = 40;

    private AnimalValidator validator;

    public AnimalFactory() {
        this.animals = new ArrayList<>();
        this.validator = new AnimalValidatorImpl();

    }

    public Animal createAnimal(AnymalType type, String name) throws IllegalArgumentException {


        Animal animal = null;

        switch (type) {
            case CAT:
                animal = new Cat();
                animal.setAmountForFull(AMOUNT_CAT_FOR_FULL);
                animal.setMaxRunDistance(MAX_CAT_RUN_DISTANCE);
                animal.setMaxSwimDistance(MAX_CAT_SWIM_DISTANCE);
                animal.setName(name);
                animal.setGender("кот");
                break;
            case DOG:
                animal = new Dog();
                animal.setAmountForFull(AMOUNT_DOG_FOR_FULL);
                animal.setMaxRunDistance(MAX_DOG_RUN_DISTANCE);
                animal.setMaxSwimDistance(MAX_DOG_SWIM_DISTANCE);
                animal.setName(name);
                animal.setGender("собака");
                break;

        }

        if (validator.isValid(animal)) {
            animals.add(animal);
            return animal;
        } else {
            throw new IllegalArgumentException("Объект не создан. Ошибка входных данных ");

        }

    }

    public String info() {
        return "\n"+"Всего создано " + getQuantityAnimals() + " животных" + "\n" +
                "котов : " + getQuantityCats() + "\n" +
                "собак : " + getQuantityDogs()+"\n";
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public long getQuantityCats() {
        return animals.stream().filter(x -> x.getGender().equals("кот")).count();
    }

    public long getQuantityDogs() {
        return animals.stream().filter(x -> x.getGender().equals("собака")).count();
    }

    public long getQuantityAnimals() {
        return animals.size();
    }
}
