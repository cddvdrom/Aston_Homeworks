package task2.Factory;

import task2.Entity.Colors;
import task2.Entity.Figure;
import task2.Entity.Triangle;

public interface TriangleFactory {
    default Figure create(Colors background, Colors border, double side1, double side2, double side3) {
        return new Triangle(background,border,side1,side2,side3);

    }
}
