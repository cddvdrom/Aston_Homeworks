package task2.Factory;


import task2.Entity.Colors;
import task2.Entity.Figure;
import task2.Entity.Oval;

public interface OvalFactory{
    default Figure create(Colors background, Colors border, int radius1,int radius2,int radius3) {
        return new Oval(background,border,radius1,radius2,radius3);

    }
}
