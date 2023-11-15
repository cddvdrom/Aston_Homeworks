package task1;

import java.util.HashMap;

public class WordAnalyser {
    public HashMap<String, Integer> analyze(String[] array) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String line : array) {
            if (map.isEmpty() || !map.containsKey(line)) {
                map.put(line, 1);
            } else {
                map.put(line, map.get(line) + 1);
            }
        }
        return map;
    }
}