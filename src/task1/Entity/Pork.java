package task1.Entity;

import task1.Validator.AnimalValidator;

public class Pork {
    private final int MAX_AMOUNT = 100;
    private int amount;


    public Pork() {

    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addFood(int extra) {

            amount = (amount + extra) > MAX_AMOUNT ? MAX_AMOUNT : amount + extra;

    }

    public void spendFood(int food) {

            amount = (amount - food) > 0 ? amount - food : 0;

            System.out.println("Еда не добавлена,тк входные данные неверны");

    }

    public void printInfo() {
        if (amount == 0) {
            System.out.println("Тарелка пуста");
        } else {
            System.out.println("В тарелке " + amount + " еды");
        }
    }
}
