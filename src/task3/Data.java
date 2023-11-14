package task3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Data {
    private final List <String> data;
    public Data () {
        this.data = new ArrayList <> (Arrays.asList(
                "f10",
                "f15",
                "f2",
                "f4",
                "f4"));
    }
    public List <String> getData() {
        return data;
    }
}