package task1.Entity;



public class Dog extends Animal {

    static int countDogs;


    public Dog() {

        super();

        countDogs++;
    }


    public boolean isSwimming() {
        return true;
    }

    public boolean isRunning() {
        return true;
    }

    public String info() {
        StringBuilder builder=new StringBuilder();
        builder.append("Информация о животном: ");
        builder.append("Вид : собака");
        builder.append("Кличка : " + super.getName());
        builder.append("Cытость : " + ((super.isFull()) ? "Сыт" : "Голоден"));
        return builder.toString();
    }



    public static int getCountDogs() {
        return countDogs;
    }
}
