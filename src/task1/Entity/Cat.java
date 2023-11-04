package task1.Entity;

import task1.Validator.RunSwimValidator;

public class Cat extends Animal {

    static int countCats;


    public Cat(String name) {
        super(150,0,20,name);
        countCats++;

    }



    public boolean isSwimming() {
        return false;
    }

    public boolean isRunning() {
        return true;
    }


    public void info() {
        System.out.println("Информация о животном: ");
        System.out.println("Вид : кот");
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
