package task2.Entity;

import task1.Result.Result;
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
    public Result perimeter() {

        return null;
    }

    @Override
    public Result area() {

        return null;
    }
}
