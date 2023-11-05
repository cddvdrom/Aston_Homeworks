package task2.Entity;

import task2.Calculate.Calculation;

public class Rectangle extends Figure implements Calculation {

    private int side1;
    private int side2;
    public Rectangle(Colors background,Colors border,int side1,int side2) {
        super(FigureType.RECTANGLE,background,border);
        this.side1=side1;
        this.side2=side2;
    }

    @Override
    public void perimeter(Figure figure) {

    }

    @Override
    public void area(Figure figure) {

    }
}
