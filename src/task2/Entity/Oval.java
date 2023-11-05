package task2.Entity;

import task1.Result.Result;
import task2.Calculate.Calculation;


public class Oval extends Figure implements Calculation {
    private double radius1;
    private double radius2;
    private double radius3;


    public Oval(Colors background,Colors border,double radius1,double radius2,double radius3) {
        super(FigureType.OVAL,background,border);
        this.radius1=radius1;
        this.radius2=radius2;
        this.radius3=radius3;
    }

    @Override
    public Result perimeter() {

        return null;
    }

    @Override
    public double area() {

        return 0;
    }
}
