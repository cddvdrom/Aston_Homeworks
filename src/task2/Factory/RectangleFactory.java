package task2.Factory;

import task2.Entity.*;

public interface RectangleFactory {

        default Figure create(Colors background, Colors border, double side1,double side2) {
            return new Rectangle(background,border,side1,side2);

        }

    }
