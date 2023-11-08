package validator;

public class MenuItemValidator implements MyValidator {
    @Override
    public boolean isValid(String line) {
        try {
            Integer.parseInt(line);
            if (line == null || line.equals("")) {
                throw new NumberFormatException("Неверный ввод");
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
