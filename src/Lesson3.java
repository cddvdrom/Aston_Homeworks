import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Lesson3 {
    public static void main(String[] args) {
        System.out.println(comparisonOfTwoIntegers(9, 12));
        chekingTheNumberAndPrintResultInConsole(1);
        chekingTheNumberAndPrintResultInConsole(0);
        chekingTheNumberAndPrintResultInConsole(-1);
        System.out.println(checkingTheNumber(1));
        System.out.println(checkingTheNumber(0));
        System.out.println(checkingTheNumber(-1));
        printStringNumberOfTimes("yandex.ru ", 5);
        System.out.println(checkLeapYear(2004));
        System.out.println(checkLeapYear(2008));
        System.out.println(checkLeapYear(2012));
        System.out.println(checkLeapYear(2016));
        System.out.println(checkLeapYear(2020));
        System.out.println(checkLeapYear(2021));
        System.out.println(checkLeapYear(2022));
        System.out.println(checkLeapYear(2023));
        System.out.println(checkLeapYear(2024));

        int[] array;
        System.out.println(Arrays.toString(array = getRandomOneZeroArray(10)));
        System.out.println(Arrays.toString(replaceZeroWithOneAndOneWithZero(array)));

        System.out.println(Arrays.toString(getArrayOfOneHundredElementsFilledInOrder()));

        int[] fixArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(fixArray));
        System.out.println(Arrays.toString(multNumberLessSixByTwo(fixArray)));

        System.out.println(Arrays.deepToString(getSquareArrayWithFilledDiagonals(10)).replace("], ", "]\n"));

        System.out.println(Arrays.toString(getArray(10, 100)));
    }

    public static boolean comparisonOfTwoIntegers(int a, int b) {
        return (a + b) >= 10 & (a + b) <= 20;
    }

    public static void chekingTheNumberAndPrintResultInConsole(int a) {
        String result = (a >= 0) ? " положительное число" : " отрицательное число";
        System.out.println(a + result);
    }

    public static boolean checkingTheNumber(int a) {
        return a >= 0;
    }

    public static void printStringNumberOfTimes(String line, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(line);
        }
    }

    public static boolean checkLeapYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0);
    }

    public static int[] getRandomOneZeroArray(int a) {
        int[] array = new int[a];
        for (int i = 0; i < array.length; i++) {
            array[i] = ThreadLocalRandom.current().nextInt(0, 2);
        }
        return array;
    }

    public static int[] replaceZeroWithOneAndOneWithZero(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0) ? 1 : 0;
        }
        return array;
    }

    public static int[] getArrayOfOneHundredElementsFilledInOrder() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static int[] multNumberLessSixByTwo(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        return array;
    }

    public static int[][] getSquareArrayWithFilledDiagonals(int a) {
        int[][] array = new int[a][a];
        for (int i = 0; i < array.length; i++) {
            array[i][i] = 1;
            array[i][a - i - 1] = 1;

        }
        return array;
    }

    public static int[] getArray(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++) {
            array[i] = initialValue;
        }
        return array;
    }

}
