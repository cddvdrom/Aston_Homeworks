package task2.Factory;


import task2.Entity.Colors;
import task2.Entity.Figure;

public  class FigureFactory implements HexagonFactory,CircleFactory,DiamondFactory,
OctagonFactory,OvalFactory,RectangleFactory,SquareFactory,TriangleFactory{

    @Override
    public Figure create(Colors background, Colors border, double diagonal1, double diagonal2) throws IllegalArgumentException {
        return DiamondFactory.super.create(background, border, diagonal1, diagonal2);
    }

    @Override
    public Figure create(Colors background, Colors border, double radius) throws IllegalArgumentException {
        return HexagonFactory.super.create(background, border, radius);
    }

    @Override
    public Figure create(Colors background, Colors border, double radius1, double radius2, double radius3) {
        return OvalFactory.super.create(background, border, radius1, radius2, radius3);
    }
}
