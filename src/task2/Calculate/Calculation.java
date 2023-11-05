package task2.Calculate;

import task1.Result.Result;
import task2.Entity.Figure;
import task2.Entity.FigureType;


public interface Calculation {
    default Result perimeter(Figure figure) {
        if(figure.getFigure().equals(FigureType.CIRCLE))
        {

        }
        return null;
    }

    default Result area() {
        return null;
    }
}
