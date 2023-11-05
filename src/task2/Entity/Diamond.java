package task2.Entity;

import task2.Calculate.Calculation;

public class Diamond extends Figure implements Calculation {
    private double diagonal1;
    private double diagonal2;

    public Diamond(Colors background,Colors border,double diagonal1,double diagonal2) {
        super(FigureType.DIAMOND,background,border);
        this.diagonal1=diagonal1;
        this.diagonal2=diagonal2;
    }

    @Override
    public void perimeter(Figure figure) {

    }

    @Override
    public void area(Figure figure) {

    }
}
