package task1.Entity;



public class Dog extends Animal {
    private final int MAX_DOG_RUN_DISTANCE=200;
    private final int MAX_DOG_SWIM_DISTANCE=50;
    private final int AMOUNT_FOR_FULL = 40;
    static int countDogs;


    public Dog(String name) {

        super();
        super.setAmountForFull(AMOUNT_FOR_FULL);
        super.setMaxRunDistance(MAX_DOG_RUN_DISTANCE);
        super.setMaxSwimDistance(MAX_DOG_SWIM_DISTANCE);
        super.setName(name);
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
