package task1.Entity;

public abstract class Animal {
    static int count;

    public Animal() {
        count++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public abstract void eat(int quantity);
}
