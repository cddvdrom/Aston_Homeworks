package task1.Service;

import task1.Entity.Animal;
import task1.Entity.Pork;

public class AnimalServiceImpl implements AnimalService{
    @Override
    public void run() {

    }

    @Override
    public void swim() {

    }

    @Override
    public void eat(Pork pork, Animal animal) {
        pork.spendFood(animal.getAmountForFull());
        animal.setFull(true);
    }
}
