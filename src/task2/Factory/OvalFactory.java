package task2.Factory;


import task2.Entity.Colors;
import task2.Entity.Figure;
import task2.Entity.Oval;
import task2.Validator.ColorValidator;
import task2.Validator.ValueValidator;

public interface OvalFactory {
    ValueValidator valueValidator = new ValueValidator();
    ColorValidator colorValidator = new ColorValidator();

    default Figure create(Colors background, Colors border, double radius1, double radius2, double radius3) {
        if (colorValidator.isValid(background) && colorValidator.isValid(border) && valueValidator.isValid(radius1)
                && valueValidator.isValid(radius2) && valueValidator.isValid(radius3)) {
            return new Oval(background, border, radius1, radius2, radius3);
        } else {
            throw new IllegalArgumentException("Неверные входные данные");
        }


    }
}
