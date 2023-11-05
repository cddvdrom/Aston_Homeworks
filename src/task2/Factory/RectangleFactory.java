package task2.Factory;

import task2.Entity.*;

public interface RectangleFactory {

        default Figure create(Colors background, Colors border, int side1,int side2) {
            return new Rectangle(background,border,side1,side2);

        }

    }
