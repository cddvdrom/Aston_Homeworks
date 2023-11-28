package ru.boronin;

import ru.boronin.calculator.Calculator;
public class StartApplication {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(calculator.sum(1,2));
    }
}
