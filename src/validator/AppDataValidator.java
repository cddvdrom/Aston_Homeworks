package validator;

public class AppDataValidator {
    public boolean validate(int columns, int lines) {
        if(columns<=0 || lines<=0){return false;}
        return true;
    }
}
