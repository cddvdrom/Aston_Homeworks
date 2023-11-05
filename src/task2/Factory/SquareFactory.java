package task2.Factory;

import task2.Entity.Colors;
import task2.Entity.Figure;
import task2.Entity.Square;
import task2.Entity.Triangle;

public interface SquareFactory {
    default Figure create(Colors background, Colors border, double side) {
        return new Square(background,border,side);

    }
}
