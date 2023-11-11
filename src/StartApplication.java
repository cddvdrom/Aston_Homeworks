
import application.ArrayResearcher;
import data.MyArrays;

public class StartApplication {
    public static void main(String[] args) {
        ArrayResearcher researcher=new ArrayResearcher();
        researcher.outputInfo(MyArrays.RIGHT_ARRAY.getArray());
        researcher.outputInfo(MyArrays.WRONG_SIZE_ARRAY.getArray());
        researcher.outputInfo(MyArrays.WRONG_DATA_ARRAY.getArray());
    }
}
