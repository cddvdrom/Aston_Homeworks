package task2.Entity;

import task2.Calculate.Calculation;


public class Rectangle extends Figure  {

    private double side1;
    private double side2;
    public Rectangle(Colors background,Colors border,double side1,double side2) {
        super(FigureType.RECTANGLE,background,border);
        this.side1=side1;
        this.side2=side2;
    }

    @Override
    public double perimeter() {

        return 2*side1+2*side2;
    }

    @Override
    public double area() {

        return side1*side2;
    }
}
