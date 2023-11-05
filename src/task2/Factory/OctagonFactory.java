package task2.Factory;


import task2.Entity.Colors;
import task2.Entity.Figure;
import task2.Entity.Octagon;

public interface OctagonFactory {
    default Figure create(Colors background, Colors border, double radius) {
        return new Octagon(background,border,radius);

    }
}
