package task1.Entity;

public abstract class Animal {

    static int count;
    private String name;
    private  int maxRunDistance;
    private  int maxSwimDistance;
    private  int amountForFull;
    private  RunSwimValidator runValidator;

    private boolean full;

    public Animal() {
        count++;
    }

    public abstract boolean isRunning();

    public abstract boolean isSwimming();

    public abstract String info();

    public String getName() {
        return name;
    }

    public boolean isFull() {
        return full;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxRunDistance() {
        return maxRunDistance;
    }

    public void setMaxRunDistance(int maxRunDistance) {
        this.maxRunDistance = maxRunDistance;
    }

    public int getMaxSwimDistance() {
        return maxSwimDistance;
    }

    public void setMaxSwimDistance(int maxSwimDistance) {
        this.maxSwimDistance = maxSwimDistance;
    }

    public int getAmountForFull() {
        return amountForFull;
    }

    public void setAmountForFull(int amountForFull) {
        this.amountForFull = amountForFull;
    }

    public RunSwimValidator getRunValidator() {
        return runValidator;
    }

    public void setRunValidator(RunSwimValidator runValidator) {
        this.runValidator = runValidator;
    }

    public void setFull(boolean full) {
        this.full = full;
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
