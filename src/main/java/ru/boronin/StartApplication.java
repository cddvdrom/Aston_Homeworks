package ru.boronin;

public class StartApplication {
    public static void main(String[] args) {
        Factorial factorial = new Factorial ();
        System.out.println(factorial.calculateRec(50));
        System.out.println(factorial.calculateStream(50));
        System.out.println(factorial.calculateLoop(50));
    }
}
