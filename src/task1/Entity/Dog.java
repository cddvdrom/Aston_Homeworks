package task1.Entity;

import task1.Validator.Validator;

public class Dog extends Animal {
    static int countDogs;
    private final int MAX_RUN_DISTANCE = 500;
    private final int MAX_SWIM_DISTANCE =  10;
    private Validator runValidator;
    private Validator swimValidator;
    private String name;

    public Dog(String name) {
        super();
        runValidator=new Validator(MAX_RUN_DISTANCE);
        swimValidator=new Validator(MAX_SWIM_DISTANCE);
        countDogs++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run(int distance) {
        if (runValidator.isValid(distance))
        {System.out.println(name + " пробежал " + distance + " метров");}
    }

    @Override
    public void swim(int distance) {
        if (swimValidator.isValid(distance))
        {System.out.println(name + " проплыл " + distance + " метров");}
    }

    @Override
    public void eat(int quantity) {
        System.out.println(name + " съел " + quantity + " еды");
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
