package task1.Validator;

import task1.Entity.Pork;

public class PorkValidatorImpl implements PorkValidator{
    @Override
    public boolean isVolumeValid(int volume) {
        return volume>0;
    }
}
