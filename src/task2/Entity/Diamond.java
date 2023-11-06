package task2.Entity;

import task2.Calculate.Calculation;


public class Diamond extends Figure{
    private double diagonal1;
    private double diagonal2;

    public Diamond(Colors background,Colors border,double diagonal1,double diagonal2) {
        super(FigureType.DIAMOND,background,border);
        this.diagonal1=diagonal1;
        this.diagonal2=diagonal2;
    }

    @Override
    public double perimeter() {

        return 4*(Math.sqrt(Math.pow(diagonal1,2)+Math.pow(diagonal2,2)))/2;
    }

    @Override
    public double area() {

        return diagonal1*diagonal2/2;
    }
}
