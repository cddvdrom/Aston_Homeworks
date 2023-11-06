package task2.Entity;

import task2.Calculate.Calculation;


public class Hexagon extends Figure {
    private double radius;
    public Hexagon(Colors background,Colors border,double radius) {
        super(FigureType.HEXAGON,background,border);
        this.radius=radius;
    }
    @Override
    public double perimeter() {

        return 6*radius;
    }

    @Override
    public double area() {

        return (3*Math.sqrt(3)*radius*radius)/2;
    }
}
