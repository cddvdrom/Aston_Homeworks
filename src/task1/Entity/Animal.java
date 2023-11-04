package task1.Entity;

import task1.Validator.RunSwimValidator;

public abstract class Animal {

    static int count;
    private final String name;
    private final int maxRunDistance;
    private final int maxSwimDistance;
    private final int amountForFull;
    private final RunSwimValidator runValidator;

    private boolean full;

    public Animal(int maxRunDistance, int maxSwimDistance, int amountForFull, String name) {
        this.runValidator = new RunSwimValidator(maxRunDistance);
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.amountForFull = amountForFull;
        this.full = false;
        this.name = name;
        count++;
    }

    public abstract boolean isRunning();

    public abstract boolean isSwimming();

    public abstract void info();

    public String getName() {
        return name;
    }

    public boolean isFull() {
        return full;
    }

    public void run(int distance) {
        if (runValidator.isValid(distance)) {
            if (isRunning() && distance <= maxRunDistance) {
                System.out.println(name + " пробежал " + distance + " метров");
            } else if (distance > maxRunDistance) {
                System.out.println(name + " не может пробежать " + distance + " метров");
            } else {
                System.out.println(name + " не умеет бегать");
            }
        }
    }

    public void swim(int distance) {
        if (isSwimming() && distance <= maxSwimDistance) {
            System.out.println(name + " проплыл " + distance + " метров");

        } else if (isSwimming() && distance > maxSwimDistance) {

        } else {
            System.out.println(name + " не умеет плавать");
        }
    }

    public void eat(Pork pork) {
        if (pork.getAmount() == 0) {
            System.out.println(name + " не поел , так как в тарелке не хватает ");
            return;
        }
        if (pork.getAmount() > amountForFull) {
            full = true;
            pork.spendFood(amountForFull);
            System.out.println(name + " поел ");
        }
    }
}
