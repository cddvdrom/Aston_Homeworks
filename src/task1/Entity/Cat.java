package task1.Entity;

import task1.Validator.RunSwimValidator;

public class Cat extends Animal {

    private final int MAX_RUN_DISTANCE =200;
    private final int MAX_SWIM_DISTANCE =  0;
    private final int AMOUNT_FOR_FULL=20;
    static int countCats;
    private String name;
    private RunSwimValidator runValidator;
    private boolean full;


    public Cat(String name){
        super();
        this.runValidator=new RunSwimValidator(MAX_RUN_DISTANCE);
        countCats++;
    full=false;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean isSwimming (){
        return false;
    }
    private boolean isRunning(){
        return true;
    }


    public void info(){
        System.out.println("Информация о животном: ");
        System.out.println("Вид : кот");
        System.out.println("Кличка : "+name);
        System.out.println("Cытость : "+((full)?"Сыт":"Голоден"));
    }
    @Override
    public void run(int distance) {
        if (runValidator.isValid(distance))
        {
            if(isRunning()&distance<=MAX_RUN_DISTANCE){
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
        if(isSwimming()&&distance<=MAX_SWIM_DISTANCE){
            System.out.println(name+" проплыл "+distance+" метров");
            return;
        }
        else if (isSwimming() &&distance>MAX_SWIM_DISTANCE){

        }
        else
        {System.out.println(name+" не умеет плавать");}
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
