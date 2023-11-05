package task1.Checker;

import task1.Entity.Animal;
import task1.Result.Result;


public class SwimChecker implements Checker {


    @Override
    public Result canPerform(Animal animal, int distance) {
        if (!animal.isSwimming()) {
            return new Result(animal.getGender() + " " + animal.getName() + " не умеет плавать");
        }
        if (actionValidator.isSwimActionValid(distance, animal)) {
            return new Result(animal.getGender() + " " + animal.getName() + " проплыл " + distance + " метров");
        }
        return new Result(animal.getGender() + " " + animal.getName() + " не смог проплыть " + distance + " метров");
    }
}
