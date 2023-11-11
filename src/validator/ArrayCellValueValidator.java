package validator;

public class ArrayCellValueValidator {
    public boolean isValid(String value){
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
