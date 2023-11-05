package task2.Factory;

import task2.Entity.Circle;
import task2.Entity.Colors;
import task2.Entity.Diamond;
import task2.Entity.Figure;

public interface DiamondFactory {

  default Figure create(Colors background, Colors border, int diagonal1,int diagonal2) {
    return new Diamond(background,border,diagonal1,diagonal2);

  }
}
