package task2.Factory;


import task2.Entity.Colors;
import task2.Entity.Figure;
import task2.Entity.Hexagon;

public interface HexagonFactory {

    default Figure create(Colors background, Colors border, int radius) {
        return new Hexagon(background,border,radius);

    }
}
