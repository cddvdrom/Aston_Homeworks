package task1.Counter;

import task1.Entity.Animal;

import java.util.ArrayList;

public class AnimalCounter {
    private ArrayList<Animal> animals;

    public AnimalCounter() {
        this.animals = new ArrayList<>();
    }
    public void add (Animal animal){
        animals.add(animal);
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

    public String info() {
        return "\n"+"Всего создано " + getQuantityAnimals() + " животных" + "\n" +
                "котов : " + getQuantityCats() + "\n" +
                "собак : " + getQuantityDogs()+"\n";
    }
}
