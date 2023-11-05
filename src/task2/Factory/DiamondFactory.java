package task2.Factory;


import task2.Entity.Colors;
import task2.Entity.Diamond;
import task2.Entity.Figure;
import task2.Validator.ColorValidator;
import task2.Validator.ValueValidator;

public interface DiamondFactory {
    ValueValidator valueValidator = new ValueValidator();
    ColorValidator colorValidator = new ColorValidator();

    default Figure create(Colors background, Colors border, double diagonal1, double diagonal2) throws IllegalArgumentException {
        if (colorValidator.isValid(background) && colorValidator.isValid(border) && valueValidator.isValid(diagonal1)
                && valueValidator.isValid(diagonal2)) {
            return new Diamond(background, border, diagonal1, diagonal2);
        } else {
            throw new IllegalArgumentException("Неверные входные данные");
        }


    }
}
