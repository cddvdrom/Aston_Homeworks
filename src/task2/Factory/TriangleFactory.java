package task2.Factory;

import task2.Entity.Colors;
import task2.Entity.Figure;
import task2.Entity.Triangle;
import task2.Validator.ColorValidator;
import task2.Validator.ValueValidator;

public class TriangleFactory{
    ValueValidator valueValidator = new ValueValidator();
    ColorValidator colorValidator = new ColorValidator();

    public Figure create(Colors background, Colors border, double side1, double side2, double side3)
            throws IllegalArgumentException {
        if (colorValidator.isValid(background) && colorValidator.isValid(border) && valueValidator.isValid(side1)
                && valueValidator.isValid(side2) && valueValidator.isValid(side3)) {
            return new Triangle(background, border, side1, side2, side3);
        } else {
            throw new IllegalArgumentException("Неверные входные данные");
        }


    }
}
