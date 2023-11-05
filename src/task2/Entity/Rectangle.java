package task2.Entity;

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
    public double perimeter() {

        return 6.5;
    }

    @Override
    public double area() {

        return 6.5;
    }
}
