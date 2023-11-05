package task1.Entity;

import task1.Result.Result;
import task1.Service.AnimalService;

import task1.Service.AnimalServiceImpl;
import task1.Validator.ActionValidator;

public abstract class Animal {
    private AnimalService service;
    private String gender;
    private String name;
    private int maxRunDistance;
    private int maxSwimDistance;
    private int amountForFull;

    private boolean full;

    public Animal() {

        this.service = new AnimalServiceImpl();
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
        Result result = service.run(this, distance);
        return result;
    }

    public Result swim(int distance) {
        Result result = service.swim(this, distance);
        return result;
    }

    public Result eat(Pork pork) {
        Result result = service.eat(this, pork);
        return result;
    }


}
