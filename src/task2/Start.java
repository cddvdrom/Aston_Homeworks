package task2;


import task1.View.Display;
import task1.View.DisplayLoader;
import task2.Entity.Colors;
import task2.Entity.Figure;
import task2.Factory.CircleFactory;

import task2.Service.InfoService;

public class Start {
    public static void main(String[] args) throws IllegalArgumentException {
        DisplayLoader loader=new DisplayLoader();
        Display display = loader.load();
        InfoService service=new InfoService();
        CircleFactory circleFactory=new CircleFactory();
        Figure circle=circleFactory.create(Colors.RED,Colors.BLUE,50.1);
        display.show(service.getFigurInfoResult(circle));


    }
}