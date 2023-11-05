package task2.Factory;

import task2.Entity.Circle;
import task2.Entity.Colors;
import task2.Entity.Figure;


public interface CircleFactory  {

default Figure create(Colors background, Colors border, int radius) {
    return new Circle(background,border,radius);

    }
}
