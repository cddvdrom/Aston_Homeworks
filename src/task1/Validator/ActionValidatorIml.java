package task1.Validator;

import task1.Entity.Animal;
import task1.Entity.Pork;

import java.util.StringJoiner;

public class ActionValidatorIml implements ActionValidator{
    @Override
    public boolean isRunActionValid(int distance, Animal animal) {
        StringJoiner errors = new StringJoiner("\n");
        if (!isDistanceValid(distance)) {
            errors.add("Некорректная дистанция");
        }
        if (animal==null) {
            errors.add("Некорретное животное");
        }

        if (errors.length() > 0) {
            throw new IllegalArgumentException(errors.toString());
        }
        return distance<animal.getMaxRunDistance() && animal.isRunning();



    }

    @Override
    public boolean isSwimActionValid(int distance, Animal animal) {
        StringJoiner errors = new StringJoiner("\n");
        if (!isDistanceValid(distance)) {
            errors.add("Некорректная дистанция");
        }
        if (animal==null) {
            errors.add("Некорретное животное");
        }

        if (errors.length() > 0) {
            throw new IllegalArgumentException(errors.toString());
        }
        return distance<animal.getMaxSwimDistance() && animal.isSwimming();
    }

    @Override
    public boolean isEatActionValid(int amount, Animal animal, Pork pork) {
        StringJoiner errors = new StringJoiner("\n");
        if (!isAmountValid(amount)) {
            errors.add("Некорректное количество еды");
        }
        if (animal==null) {
            errors.add("Некорретное животное");
        }

        if (errors.length() > 0) {
            throw new IllegalArgumentException(errors.toString());
        }
        return amount>=animal.getAmountForFull() && pork.getAmount()>=amount;
    }

    @Override
    public boolean isDistanceValid(int distance) {
        return distance>0;
    }
    @Override
    public boolean isAmountValid(int amount) {
        return amount>0;
    }
}
