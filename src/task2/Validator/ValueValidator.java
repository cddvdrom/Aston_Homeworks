package task2.Validator;



public class ValueValidator {
    public boolean isValid (double value){
        return value>0 && value<Double.MAX_VALUE;
    }

}
