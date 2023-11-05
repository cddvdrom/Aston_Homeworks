package task2.Entity;

import task2.Calculate.Calculation;

public class Octagon extends Figure implements Calculation {
    private int radius;

    public Octagon(Colors background,Colors border,int radius) {
        super(FigureType.OCTAGON,background,border);
        this.radius=radius;
    }

    @Override
    public void perimeter(Figure figure) {

    }

    @Override
    public void area(Figure figure) {

    }
}
