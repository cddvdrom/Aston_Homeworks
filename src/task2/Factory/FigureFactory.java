package task2.Factory;

import task2.Entity.Colors;
import task2.Entity.Figure;

public abstract class FigureFactory{
  abstract Figure create();

    public abstract Figure create(Colors red, Colors blue, double v);
}
