package task1.Entity;

import task1.Validator.RunSwimValidator;

public class Dog extends Animal {
    static int countDogs;


    public Dog(String name) {
        super(200, 100, 30, name);
        countDogs++;
    }


    public boolean isSwimming() {
        return true;
    }

    public boolean isRunning() {
        return true;
    }

    public void info() {
        System.out.println("Информация о животном: ");
        System.out.println("Вид : собака");
        System.out.println("Кличка : " + super.getName());
        System.out.println("Cытость : " + ((super.isFull()) ? "Сыт" : "Голоден"));
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
