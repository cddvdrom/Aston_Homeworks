package task2.Factory;

import task2.Entity.*;
import task2.Validator.ColorValidator;
import task2.Validator.ValueValidator;

public interface SquareFactory {
    ValueValidator valueValidator = new ValueValidator();
    ColorValidator colorValidator = new ColorValidator();

    default Figure create(Colors background, Colors border, double side) throws IllegalArgumentException {
        if (colorValidator.isValid(background) && colorValidator.isValid(border) && valueValidator.isValid(side)) {
            return new Square(background, border, side);
        } else {
            throw new IllegalArgumentException("Неверные входные данные");
        }


    }
}
