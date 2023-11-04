package task1.Entity;

import task1.Result.Result;
import task1.Service.EatService;
import task1.Service.EatServiceImpl;
import task1.Validator.ActionValidator;
import task1.Validator.ActionValidatorIml;

public abstract class Animal {
private EatService eatService;
    private String gender;
    private String name;
    private int maxRunDistance;
    private int maxSwimDistance;
    private int amountForFull;
    private ActionValidator actionValidator;
    private boolean full;

    public Animal() {
        this.actionValidator = new ActionValidatorIml();
        this.eatService=new EatServiceImpl();
    }


    public abstract boolean isRunning();

    public abstract boolean isSwimming();

    public String info() {
        StringBuilder builder = new StringBuilder();
        builder.append("Информация о животном: " + "\n");
        builder.append("Вид : кот" + "\n");
        builder.append("Кличка : " + name + "\n");
        builder.append("Cытость : " + ((full) ? "Сыт" : "Голоден") + "\n");
        return builder.toString();
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public Result run(int distance) {
        if (!isRunning()) {
            return new Result(gender + " " + name + " не умеет бегать");
        }
        if (actionValidator.isRunActionValid(distance, this)) {
            return new Result(gender + " " + name + " пробежал " + distance + " метров");
        }
        return new Result(gender + " " + name + " не смог пробежать " + distance + " метров");
    }

    public Result swim(int distance) {
        if (!isSwimming()) {
            return new Result(gender + " " + name + " не умеет плавать");
        }
        if (actionValidator.isSwimActionValid(distance, this)) {
            return new Result(gender + " " + name + " проплыл " + distance + " метров");
        }
        return new Result(gender + " " + name + " не смог проплыть " + distance + " метров");
    }

    public Result eat(Pork pork) {
        if (actionValidator.isEatActionValid(pork.getAmount(), this, pork)) {
            {
                eatService.eat(pork,this);
            }
            return new Result(gender + " " + name + " поел" + ".В тарелке осталось " + pork.getAmount());
        }
        return new Result(gender + " " + name + " не смог поесть" + ".В тарелке " + pork.getAmount());
    }


}
