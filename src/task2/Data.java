package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {
    private final List <String> data;

    public Data () {
        this.data = new ArrayList <> (Arrays.asList(
                "HighLoad",
                "High",
                "Load",
                "Highload"));
    }
    public List <String> getData() {
        return data;
    }
}
