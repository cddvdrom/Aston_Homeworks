package task1.Validator;

public class RunSwimValidator extends Validator {
    private int maxDistance;

    public RunSwimValidator(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public boolean isValid(int distance) {
        return (distance > maxDistance || distance > 0);

    }
}
