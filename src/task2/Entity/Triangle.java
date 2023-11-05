package task2.Entity;

import task2.Calculate.Calculation;

public class Triangle extends Figure implements Calculation {
    private int side1;
    private int side2;
    private int side3;
    public Triangle(Colors background,Colors border,int side1,int side2,int side3) {
        super(FigureType.TRIANGLE,background,border);
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
    }

    @Override
    public void perimeter(Figure figure) {

    }

    @Override
    public void area(Figure figure) {

    }
}
