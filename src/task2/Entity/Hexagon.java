package task2.Entity;

import task1.Result.Result;
import task2.Calculate.Calculation;


public class Hexagon extends Figure implements Calculation {
    private double radius;
    public Hexagon(Colors background,Colors border,double radius) {
        super(FigureType.HEXAGON,background,border);
        this.radius=radius;
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
