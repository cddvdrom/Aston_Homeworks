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




    public static int getCountDogs() {
        return countDogs;
    }
}
