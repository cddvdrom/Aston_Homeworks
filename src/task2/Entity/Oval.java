package task2.Entity;

import task2.Calculate.Calculation;

public class Oval extends Figure implements Calculation {
    private int radius1;
    private int radius2;
    private int radius3;


    public Oval(Colors background,Colors border,int radius1,int radius2,int radius3) {
        super(FigureType.OVAL,background,border);
        this.radius1=radius1;
        this.radius2=radius2;
        this.radius3=radius3;
    }

    @Override
    public void perimeter(Figure figure) {

    }

    @Override
    public void area(Figure figure) {

    }
}
