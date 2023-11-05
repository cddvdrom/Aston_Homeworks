package task1.Factory;

import task1.Entity.Pork;
import task1.Validator.PorkValidator;

public class PorkFactory {
    private PorkValidator validator;

    public PorkFactory() {
        this.validator = new PorkValidator();
    }

    public Pork createPork(int volume) {

        if (validator.isVolumeValid(volume)) {
            Pork pork = new Pork(volume);
            return pork;
        } else {
            throw new IllegalArgumentException("Ошибка при создании тарелки.Неверный объем");
        }
    }
}
