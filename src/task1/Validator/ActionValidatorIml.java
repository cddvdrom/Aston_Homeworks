package task1.Validator;

public class ActionValidatorIml implements ActionValidator{
    @Override
    public boolean runDistanceIsValid(int distance) {
        return false;
    }

    @Override
    public boolean swimDistanceIsValid(int distance) {
        return false;
    }

    @Override
    public boolean amountFoodIsValid(int amount) {
        return false;
    }
}
