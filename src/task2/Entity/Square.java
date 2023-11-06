package task2.Entity;

import task2.Calculate.Calculation;


public class Square extends Figure {
    private double side;

    public Square( Colors background, Colors border,double side) {
        super(FigureType.SQUARE, background, border);
        this.side=side;
    }

    @Override
    public double perimeter() {

        return 4*side;
    }

    @Override
    public double area() {

        return side*side;
    }
}
