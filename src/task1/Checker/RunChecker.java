package task1.Checker;

import task1.Entity.Animal;
import task1.Result.Result;


public class RunChecker implements Checker {


    @Override
    public Result canPerform(Animal animal, int distance) {
        if (!animal.isRunning()) {
            return new Result(animal.getGender() + " " + animal.getName() + " не умеет бегать");
        }
        if (actionValidator.isRunActionValid(distance, animal)) {
            return new Result(animal.getGender() + " " + animal.getName() + " пробежал " + distance + " метров");
        }
        return new Result(animal.getGender() + " " + animal.getName() + " не смог пробежать " + distance + " метров");
    }
}
