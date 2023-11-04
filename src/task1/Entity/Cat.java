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





    public static int getCountCats() {
        return countCats;
    }
}
