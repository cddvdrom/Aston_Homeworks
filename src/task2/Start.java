package task2;

import task2.Entity.Circle;
import task2.Entity.Colors;



public class Start {
    public static void main(String[] args) {


        Circle circle1=new Circle(Colors.RED,Colors.BLUE,5.1);
        System.out.println(circle1.perimeter());


    }
}