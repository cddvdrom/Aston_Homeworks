package task1.Validator;

import task1.Entity.Animal;

public class ActionValidatorIml implements ActionValidator{
    @Override
    public boolean runDistanceIsValid(int distance, Animal animal) {
        return false;
    }

    @Override
    public boolean swimDistanceIsValid(int distance, Animal animal) {
        return false;
    }

    @Override
    public boolean amountFoodIsValid(int amount, Animal animal) {
        return false;
    }
}
