package task2.Entity;

import task2.Calculate.Calculation;

public class Square extends Figure implements Calculation {
    private int side;

    public Square( Colors background, Colors border,int side) {
        super(FigureType.SQUARE, background, border);
        this.side=side;
    }

    @Override
    public void perimeter(Figure figure) {

    }

    @Override
    public void area(Figure figure) {

    }
}
