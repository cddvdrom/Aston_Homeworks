import application.ArrayOperations;
import data.MyArrays;

public class StartApplication {
    public static void main(String[] args) {
        ArrayOperations arrayOperations=new ArrayOperations();
        arrayOperations.sum(MyArrays.RIGHT_ARRAY.getArray());
        arrayOperations.sum(MyArrays.WRONG_ARRAY.getArray());
    }
}
