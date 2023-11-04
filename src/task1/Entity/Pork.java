package task1.Entity;

public class Pork {
    private final int VOLUME;
    private int amount;

    public Pork(int volume) {
        VOLUME = volume;
    }


    public int getAmount() {
        return amount;
    }


    public int getVOLUME() {
        return VOLUME;
    }

    public void addFood(int extra) {

            amount = (amount + extra) > VOLUME ? VOLUME : amount + extra;

    }

    public void spendFood(int food) {

            amount = (amount - food) > 0 ? amount - food : 0;


    }


}
