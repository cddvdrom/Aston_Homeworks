import java.io.Console;

public class Lesson2 {
    public static void main(String[] args) {


        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }
    // Задание 1
    public static void printThreeWords() {

        String firstWord = "Orange";
        String secondWord = "Banana";
        String thirdWord = "Apple";

        System.out.print(firstWord + "\n" + secondWord + "\n" + thirdWord + "\n");
    }
    // Задание 2
    public static void checkSumSign() {
        int a = 1;
        int b = 2;
        int sum = a + b;
        String result = (sum >= 0) ? " Cумма положительная" : "Сумма отрицательная";
        System.out.println(result);


    }
    // Задание 3
    public static void printColor() {
        int value = 0;
        String result = (value <= 0) ? "Красный" : (value > 0 & value <= 100) ? "Желтый" : "Зеленый";
        System.out.println(result);
    }
    // Задание 4
    public static void compareNumbers() {
        int a = 20;
        int b = 2;
        String result = (a >= b) ? "a>=b" : "a<b";
        System.out.println(result);

    }
}
