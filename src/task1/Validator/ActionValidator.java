package task1.Validator;

import task1.Entity.Animal;
import task1.Entity.Pork;

public interface ActionValidator {
    boolean isRunActionValid(int distance, Animal animal);
    boolean isSwimActionValid(int distance,Animal animal);
    boolean isEatActionValid(int amount, Animal animal, Pork pork);
    boolean isDistanceValid(int distance);
    boolean isAmountValid(int amount);
}
