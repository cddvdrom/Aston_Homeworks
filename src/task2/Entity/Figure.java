package task2.Entity;

import task2.Calculate.Calculation;

public abstract class Figure implements Calculation {
    private FigureType figure;
    private Colors background;
    private Colors border;


    public Figure(FigureType figure,Colors background,Colors border)
    {
        this.figure = figure;
        this.background=background;
        this.border=border;
    }

    public FigureType getFigure() {
        return figure;
    }

    public Colors getBackground() {
        return background;
    }

    public Colors getBorder() {
        return border;
    }
}
