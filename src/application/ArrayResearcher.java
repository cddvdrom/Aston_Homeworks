package application;

import java.util.Arrays;

public class ArrayResearcher {
    public void outputInfo(String[][] array) {
        ArrayOperations arrayOperations = new ArrayOperations();
        System.out.println("Суммируется массив :");
        System.out.println(Arrays.deepToString(array));
        System.out.println("Сумма = " + arrayOperations.sum(array));
        System.out.println("");

    }
}
