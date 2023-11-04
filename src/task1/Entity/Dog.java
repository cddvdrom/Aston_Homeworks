package task1.Entity;

import task1.Validator.RunSwimValidator;

public class Dog extends Animal {
    static int countDogs;
    private final int AMOUNT_FOR_FULL=20;
    private final int MAX_RUN_DISTANCE = 500;
    private final int MAX_SWIM_DISTANCE =  10;
    private RunSwimValidator runValidator;
    private RunSwimValidator swimValidator;
    private String name;
    private boolean full;
    private boolean hungry;

    public Dog(String name) {
        super();
        runValidator=new RunSwimValidator(MAX_RUN_DISTANCE);
        swimValidator=new RunSwimValidator(MAX_SWIM_DISTANCE);
        countDogs++;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean isSwimming (){
        return true;
    }
    private boolean isRunning(){
        return true;
    }

    @Override
    public void run(int distance) {
        if (runValidator.isValid(distance))
        {
            if(isRunning()&&distance<=MAX_RUN_DISTANCE){
                System.out.println(name+" пробежал "+distance+" метров");
            }
            else if (distance>MAX_SWIM_DISTANCE){
                System.out.println(name+" не может пробежать "+distance+" метров");
            }
            else
            {System.out.println(name+" не умеет бегать");}
        }
    }

    @Override
    public void swim(int distance) {
        if (swimValidator.isValid(distance))
        {
            if(isSwimming()&&distance<=MAX_SWIM_DISTANCE){
                System.out.println(name+" проплыл "+distance+" метров");
                return;
            }
            else if (distance>MAX_SWIM_DISTANCE){

            }
            else
            {System.out.println(name+" не умеет плавать");}
        }
    }

    @Override
    public void eat(Pork pork) {
        if(pork.getAmount()==0){System.out.println(name + " не поел , так как в тарелке не хватает ");return;}
        if (pork.getAmount()>AMOUNT_FOR_FULL){
            full=true;
            pork.spendFood(AMOUNT_FOR_FULL);
            System.out.println(name + " поел ");}
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
