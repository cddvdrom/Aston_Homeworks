package task2.Entity;

import task2.Calculate.Calculation;

import javax.swing.plaf.synth.ColorType;

public class Circle extends Figure implements Calculation {
    private int radius;

    public Circle(Colors background, Colors border, int radius) {
        super(FigureType.CIRCLE,background,border);
        this.radius=radius;
    }

    @Override
    public void perimeter(Figure figure) {

    }

    @Override
    public void area(Figure figure) {

    }
}
