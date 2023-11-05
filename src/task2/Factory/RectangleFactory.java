package task2.Factory;

import task2.Entity.*;
import task2.Validator.ColorValidator;
import task2.Validator.ValueValidator;

public class RectangleFactory{
    ValueValidator valueValidator = new ValueValidator();
    ColorValidator colorValidator = new ColorValidator();

  public Figure create(Colors background, Colors border, double side1, double side2) throws IllegalArgumentException {
        if (colorValidator.isValid(background) && colorValidator.isValid(border) && valueValidator.isValid(side2)
                && valueValidator.isValid(side2)) {
            return new Rectangle(background, border, side1, side2);
        } else {
            throw new IllegalArgumentException("Неверные входные данные");
        }


    }

}
