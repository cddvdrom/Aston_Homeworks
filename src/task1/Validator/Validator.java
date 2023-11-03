package task1.Validator;

public class Validator {
    private int maxDistance;

    public Validator(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public boolean isValid(int distance){
        return (distance>maxDistance || distance>0);

    }
}
