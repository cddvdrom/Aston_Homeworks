package task1.Entity;

import task1.Validator.EatValidator;
import task1.Validator.Validator;

public class Pork {
    private final int MAX_AMOUNT=100;
    private int amount;
    private Validator eatValidator;

    public Pork(){
        this.eatValidator=new EatValidator();
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addFood(int extra ){
        if (eatValidator.isValid(extra))
        {amount= (amount+extra)>MAX_AMOUNT?MAX_AMOUNT:amount+extra;}
        else {System.out.println("Еда не добавлена,тк входные данные неверны");}
    }

    public void spendFood(int food){
        if (eatValidator.isValid(food))
        {amount= (amount-food)>0?amount-food:0;}
        else {System.out.println("Еда не добавлена,тк входные данные неверны");}
    }
public void printInfo(){
        if (amount==0) { System.out.println("Тарелка пуста");}
        else
        {System.out.println("В тарелке "+amount+" еды");}
}
}
