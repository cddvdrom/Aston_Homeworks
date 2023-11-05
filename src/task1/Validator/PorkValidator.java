package task1.Validator;

public class PorkValidator implements PorkValidator{
    @Override
    public boolean isVolumeValid(int volume) {
        return volume>0;
    }
}
