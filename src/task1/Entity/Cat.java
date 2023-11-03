package task1.Entity;

import task1.Validator.Validator;

public class Cat extends Animal {
    private final int MAX_RUN_DISTANCE=200;
    static int countCats;
    private String name;
    private Validator runValidator;

    public Cat(String name){
        super();
        this.runValidator=new Validator(MAX_RUN_DISTANCE);
        countCats++;
        this.name=name;
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
        {System.out.println(name+" пробежал "+distance+" метров");}
        else {System.out.println("Входные данные некорректны");}
    }

    @Override
    public void swim(int distance) {
        System.out.println(name+" не умеет плавать");
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
