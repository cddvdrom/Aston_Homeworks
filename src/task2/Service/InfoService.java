package task2.Service;

import task1.Result.Result;
import task2.Entity.Figure;

public class InfoService {
    public Result getFigurInfoResult(Figure figure) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("===============");
        stringBuilder.append("\n");
        stringBuilder.append("Информация о фигуре :");
        stringBuilder.append("\n");
        stringBuilder.append("===============");
        stringBuilder.append("\n");
        stringBuilder.append(figure.getFigure().getName());
        stringBuilder.append("\n");
        stringBuilder.append("Цвет фона :");
        stringBuilder.append(figure.getBackground().getColor());
        stringBuilder.append("\n");
        stringBuilder.append("Цвет границы :");
        stringBuilder.append(figure.getBorder().getColor());
        stringBuilder.append("\n");
        stringBuilder.append("Периметр :");
        stringBuilder.append(figure.perimeter());
        stringBuilder.append("\n");
        stringBuilder.append("Площадь :");
        stringBuilder.append(figure.area());
        stringBuilder.append("\n");
        stringBuilder.append("===============");
        Result result = new Result(stringBuilder.toString());


        return result;
    }
}
