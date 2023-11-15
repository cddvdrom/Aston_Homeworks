package task1;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordAnalyser {
    public HashMap<String, Integer> analyze1(String[] array) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String line : array) {
            if (map.isEmpty() || !map.containsKey(line)) {
                map.put( line, 1);
            } else {
                map.put( line, map.get(line) + 1 );
            }
        }
        return map;
    }

    public HashMap<String, Integer> analyze2(String[] array) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String string : array) {
            map.compute(string, (k, v) -> v == null ? 1 : v + 1);
        }
        return map;
    }

    public Map<String, Long> analyze3(String[] array) {
        Map<String, Long> map = Stream.of(array).collect(Collectors.groupingBy((k) -> k, Collectors.counting()));
        return map;
    }
    public Map<String, Long> analyze4(String[] array) {
        Map<String, Long> map = Stream.of(array).parallel().collect(Collectors.groupingBy((k) -> k, Collectors.counting()));
        return map;
    }
}

