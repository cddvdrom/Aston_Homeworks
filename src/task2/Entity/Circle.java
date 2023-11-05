package task2.Entity;

import task2.Calculate.Calculation;

public class Circle extends Figure implements Calculation {
    private int radius;

    public Circle(FigureType figure) {
        super(figure);
    }

    @Override
    public void perimeter(Figure figure) {

    }

    @Override
    public void area(Figure figure) {

    }
}
