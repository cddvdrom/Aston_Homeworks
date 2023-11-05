package task1.Factory;

public enum AnimalType {
    DOG(500, 10, 40),
    CAT(200, 0, 20);

    private final int MAX_RUN_DISTANCE;
    private final int MAX_SWIM_DISTANCE;
    private final int AMOUNT_FOR_FULL;

    AnimalType(int maxRunDistance, int maxSwimDistance, int amountForFull) {
        this.MAX_RUN_DISTANCE = maxRunDistance;
        this.MAX_SWIM_DISTANCE = maxSwimDistance;
        this.AMOUNT_FOR_FULL = amountForFull;


    }

    public int MAX_RUN_DISTANCE() {
        return MAX_RUN_DISTANCE;
    }

    public int MAX_SWIM_DISTANCE() {
        return MAX_SWIM_DISTANCE;
    }

    public int AMOUNT_FOR_FULL() {
        return AMOUNT_FOR_FULL;
    }
}
