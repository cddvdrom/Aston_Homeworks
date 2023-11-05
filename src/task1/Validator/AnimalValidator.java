package task1.Validator;

import task1.Entity.Animal;

import java.util.StringJoiner;

public class AnimalValidator {


    public boolean isValid(Animal animal) {


        StringJoiner errors = new StringJoiner("\n");
        if (!isNameValid(animal.getName())) {
            errors.add("Имя не удовлетворяет критериям");
        }
        if (!isMaxRunDistanceValid(animal.getMaxRunDistance())) {
            errors.add("Параметр макс дистанции бега не удовлетворяет критериям");
        }
        if (!isMaxSwimDistanceValid(animal.getMaxSwimDistance())) {
            errors.add("Параметр макс дистанции плавания не удовлетворяет критериям");
        }
        if (!isAmountForFullValid(animal.getAmountForFull())) {
            errors.add("Параметр необходимого количества еды для сытости не удовлетворяет критериям");
        }
        if (errors.length() > 0) {
            throw new IllegalArgumentException(errors.toString());
        }


        return true;
    }

    private boolean isNameValid(String name) {
        return name != null && !name.isEmpty();
    }

    private boolean isMaxRunDistanceValid(int maxRunDistance) {
        return maxRunDistance >= 0;
    }

    private boolean isMaxSwimDistanceValid(int maxSwimDistance) {
        return maxSwimDistance >= 0;
    }

    private boolean isAmountForFullValid(int amountForFull) {
        return amountForFull >= 0;
    }

}


