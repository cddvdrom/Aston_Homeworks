package task2.Entity;

import task2.Calculate.Calculation;

public class Circle extends Figure implements Calculation {
    private double radius;

    public Circle(Colors background, Colors border, double radius) {
        super(FigureType.CIRCLE,background,border);
        this.radius=radius;
    }

    @Override
    public double perimeter() {
        return 2*Math.PI*radius;
    }

    @Override
    public double area() {
        return Math.PI*(radius*radius);
    }
}
