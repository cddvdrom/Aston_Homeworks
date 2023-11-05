package task1.Checker;

import task1.Entity.Animal;
import task1.Result.Result;
import task1.Validator.ActionValidator;

public interface Checker {
    ActionValidator actionValidator = new ActionValidator();

    Result canPerform(Animal animal, int value);
}
