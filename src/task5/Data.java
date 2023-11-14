package task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Data {
    private final List<String> listData;

    public Data() {
        this.listData = new ArrayList<>();
    }
    public void input() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean isExit = false;
            while (!isExit) {
                String line = reader.readLine();
                if (!line.isEmpty()) {
                    listData.add(line);
                } else {
                    isExit = true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<String> findDataCondition(SearchCondition condition, String item) {
        return listData.stream().filter(x -> condition.compare(x, item)).collect(Collectors.toList());
    }
}
