package task2.Entity;

import task1.Result.Result;
import task2.Calculate.Calculation;


public class Octagon extends Figure implements Calculation {
    private double radius;

    public Octagon(Colors background,Colors border,double radius) {
        super(FigureType.OCTAGON,background,border);
        this.radius=radius;
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
