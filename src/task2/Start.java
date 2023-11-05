package task2;


import task1.View.Display;
import task1.View.DisplayLoader;
import task2.Entity.Colors;
import task2.Entity.Figure;
import task2.Factory.CircleFactory;
import task2.Factory.FigureFactory;

public class Start {
    public static void main(String[] args) throws IllegalArgumentException {
        DisplayLoader loader=new DisplayLoader();
        Display display = loader.load();
        CircleFactory circleFactory=new FigureFactory();
        Figure circle=circleFactory.create(Colors.RED,Colors.BLUE,5.1);
        display.show(circle.perimeter());
        display.show(circle.area());


    }
}