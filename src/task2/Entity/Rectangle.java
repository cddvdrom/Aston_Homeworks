package task2.Entity;

import task1.Result.Result;
import task2.Calculate.Calculation;


public class Rectangle extends Figure implements Calculation {

    private double side1;
    private double side2;
    public Rectangle(Colors background,Colors border,double side1,double side2) {
        super(FigureType.RECTANGLE,background,border);
        this.side1=side1;
        this.side2=side2;
    }

    @Override
    public Result perimeter() {

        return null;
    }

    @Override
    public Result area() {

        return null;
    }
}
