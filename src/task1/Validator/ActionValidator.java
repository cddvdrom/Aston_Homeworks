package task1.Validator;

import task1.Entity.Animal;

public interface ActionValidator {
    boolean runDistanceIsValid(int distance, Animal animal);
    boolean swimDistanceIsValid(int distance,Animal animal);
    boolean amountFoodIsValid(int amount,Animal animal);
}
