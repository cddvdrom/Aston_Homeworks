package task2.Entity;

import task2.Calculate.Calculation;

public class Diamond extends Figure implements Calculation {
    private int diagonal1;
    private int diagonal2;

    public Diamond(FigureType figure,Colors background,Colors border,int diagonal1,int diagonal2) {
        super(figure,background,border);
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
