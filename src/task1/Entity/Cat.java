package task1.Entity;


public class Cat extends Animal {


    static int countCats;


    public Cat() {
        super();



        countCats++;

    }


    public boolean isSwimming() {
        return false;
    }

    public boolean isRunning() {
        return true;
    }


    public String info() {
        StringBuilder builder=new StringBuilder();
        builder.append("Информация о животном: ");
        builder.append("Вид : кот");
        builder.append("Кличка : " + super.getName());
        builder.append("Cытость : " + ((super.isFull()) ? "Сыт" : "Голоден"));
        return builder.toString();
    }



    public static int getCountCats() {
        return countCats;
    }
}
