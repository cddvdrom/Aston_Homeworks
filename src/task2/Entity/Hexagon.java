package task2.Entity;

import task2.Calculate.Calculation;


public class Hexagon extends Figure implements Calculation {
    private double radius;
    public Hexagon(Colors background,Colors border,double radius) {
        super(FigureType.HEXAGON,background,border);
        this.radius=radius;
    }
    @Override
    public double perimeter() {

        return 7.5;
    }

    @Override
    public double area() {

        return 7.5;
    }
}
