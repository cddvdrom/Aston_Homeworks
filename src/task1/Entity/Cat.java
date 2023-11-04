package task1.Entity;


public class Cat extends Animal {
    private final int MAX_CAT_RUN_DISTANCE = 100;
    private final int MAX_CAT_SWIM_DISTANCE = 0;
    private final int AMOUNT_FOR_FULL = 20;

    static int countCats;


    public Cat(String name) {
        super();
        super.setAmountForFull(AMOUNT_FOR_FULL);
        super.setMaxRunDistance(MAX_CAT_RUN_DISTANCE);
        super.setMaxSwimDistance(MAX_CAT_SWIM_DISTANCE);
        super.setName(name);


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
