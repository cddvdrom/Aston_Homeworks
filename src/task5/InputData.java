package task5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class InputData {
    public List <String> input() {
        ArrayList <String> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            boolean isExit = false;
            while (!isExit) {
                String line = reader.readLine();
                if (!line.isEmpty()) {
                    list.add(line);
                } else {
                    isExit = true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
