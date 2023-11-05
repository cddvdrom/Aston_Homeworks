package task2.Entity;

import task2.Calculate.Calculation;


public class Octagon extends Figure implements Calculation {
    private double radius;

    public Octagon(Colors background,Colors border,double radius) {
        super(FigureType.OCTAGON,background,border);
        this.radius=radius;
    }

    @Override
    public double perimeter() {

        return 8*radius*Math.sqrt(2-Math.sqrt(2));
    }

    @Override
    public double area() {

        return 2*Math.pow(radius,2)*(1+Math.sqrt(2));
    }
}
