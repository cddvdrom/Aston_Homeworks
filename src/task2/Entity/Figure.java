package task2.Entity;

public abstract class Figure  {
    private FigureType figure;
    private Colors background;
    private Colors border;


    public Figure(FigureType figure) {
        this.figure = figure;
    }
}
