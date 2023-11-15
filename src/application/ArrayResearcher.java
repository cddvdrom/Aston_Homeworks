package application;
import java.util.Arrays;

public class ArrayResearcher {
    public void outputInfo(String[][] array) {
        ArrayOperations arrayOperations = new ArrayOperations();
        System.out.println("Исследуется массив :");
        System.out.println(Arrays.deepToString(array).replace("], ", "]\n"));
        System.out.println("Сумма значений = " + arrayOperations.sum(array));
        System.out.println();
    }
}
