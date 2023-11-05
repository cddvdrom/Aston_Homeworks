package task2.Entity;

import task2.Calculate.Calculation;


public class Triangle extends Figure implements Calculation {
    private double side1;
    private double side2;
    private double side3;
    public Triangle(Colors background,Colors border,double side1,double side2,double side3) {
        super(FigureType.TRIANGLE,background,border);
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
    }

    @Override
    public double perimeter() {

        return 1.5;
    }

    @Override
    public double area() {

        return 2.5;
    }
}
