package task1.Validator;

public class EatValidator extends Validator{
    public boolean isValid (int amount){
        return amount>=0;
    }
}
