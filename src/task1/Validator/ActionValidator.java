package task1.Validator;

import task1.Entity.Animal;
import task1.Entity.Pork;

import java.util.StringJoiner;

public class ActionValidator {

    public boolean isRunActionValid(int distance, Animal animal) {
        findErrors(distance, animal);
        return distance <= animal.getMaxRunDistance() && animal.isRunning();


    }


    public boolean isSwimActionValid(int distance, Animal animal) {
        findErrors(distance, animal);
        return distance <= animal.getMaxSwimDistance() && animal.isSwimming();
    }


    public boolean isEatActionValid(int amount, Animal animal, Pork pork) {
        findErrors(amount, animal);
        return amount >= animal.getAmountForFull() && pork.getAmount() >= amount;
    }

    public boolean isAmountValid(int amount) {
        return amount > 0;
    }

    public void findErrors(int amount, Animal animal) {
        StringJoiner errors = new StringJoiner("\n");
        if (!isAmountValid(amount)) {
            errors.add("Некорректные данные");
        }
        if (animal == null) {
            errors.add("Некорретное животное");
        }

        if (errors.length() > 0) {
            throw new IllegalArgumentException(errors.toString());
        }
    }
}