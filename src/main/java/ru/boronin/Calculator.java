package ru.boronin;

public class Calculator {
    public double sum(double a, double b) {
        return a + b;
    }
    public double sub(double a, double b) {
        return a - b;
    }
    public double mult(double a, double b) {
        return a * b;
    }
    public double div(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return a / b;
    }
}
