package task2.Entity;

import task2.Calculate.Calculation;

public class Square extends Figure implements Calculation {
    private double side;

    public Square( Colors background, Colors border,double side) {
        super(FigureType.SQUARE, background, border);
        this.side=side;
    }

    @Override
    public double perimeter() {

        return 0;
    }

    @Override
    public double area() {

        return 0;
    }
}
