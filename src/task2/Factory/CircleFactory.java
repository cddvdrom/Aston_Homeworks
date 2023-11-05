package task2.Factory;

import task2.Entity.Circle;
import task2.Entity.Colors;
import task2.Entity.Figure;
import task2.Validator.ColorValidator;
import task2.Validator.ValueValidator;


public class CircleFactory {
    ValueValidator valueValidator = new ValueValidator();
    ColorValidator colorValidator = new ColorValidator();

    public Figure create(Colors background, Colors border, double radius) throws IllegalArgumentException {
        if (colorValidator.isValid(background) && colorValidator.isValid(border) && valueValidator.isValid(radius)) {
            return new Circle(background, border, radius);
        } else {
            throw new IllegalArgumentException("Неверные входные данные");
        }
    }
}
