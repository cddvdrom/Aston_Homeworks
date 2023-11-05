package task1.Service;

import task1.Checker.Checker;
import task1.Checker.EatChecker;
import task1.Checker.RunChecker;
import task1.Checker.SwimChecker;
import task1.Entity.Animal;
import task1.Entity.Pork;
import task1.Result.Result;


public class AnimalServiceImpl implements AnimalService {
    private final Checker runChecker;
    private final Checker swimChecker;
    private EatChecker eatChecker;

    public AnimalServiceImpl() {
        runChecker = new RunChecker();
        swimChecker = new SwimChecker();
        eatChecker = new EatChecker();
    }

    @Override
    public Result run(Animal animal, int distance) {
        Result result = runChecker.canPerform(animal, distance);
        return result;

    }

    @Override
    public Result swim(Animal animal, int distance) {
        Result result = swimChecker.canPerform(animal, distance);
        return result;
    }

    @Override
    public Result eat(Animal animal, Pork pork) {
        Result result = eatChecker.canPerform(animal, pork);
        pork.spendFood(animal.getAmountForFull());
        animal.setFull(true);
        return result;
    }
}
