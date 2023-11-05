package task1.Checker;

import task1.Entity.Animal;
import task1.Entity.Pork;
import task1.Result.Result;

import static task1.Checker.Checker.actionValidator;


public class EatChecker {


    public Result canPerform(Animal animal, Pork pork) {
        if (actionValidator.isEatActionValid(pork.getAmount(), animal, pork)) {
            {
                return new Result(animal.getGender() + " " + animal.getName() + " поел" + ".В тарелке осталось " + pork.getAmount());
            }
        }
        return new Result(animal.getGender() + " " + animal.getName() + " не смог поесть" + ".В тарелке " + pork.getAmount());
    }
}
