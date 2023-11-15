package task1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordAnalyser {
    public Supplier <Map <String , Long>> analyze1 (String[] array) {
        return () -> {
            Map< String , Long> map = new HashMap<>();
            for (String line : array) {
                if (map.isEmpty() || !map.containsKey(line)) {
                    map.put(line, 1L);
                } else {
                    map.put(line, map.get(line) + 1);
                }
            }
            return map;
        };
    }
    public Supplier <Map <String , Long>> analyze2 (String[] array) {
        return () -> {
            Map<String, Long> map = new HashMap<>();
            for (String string : array) {
                map.compute(string, ( k,v ) -> v == null ? 1 : v + 1);
            }
            return map;
        };
    }
    public Supplier <Map <String , Long>> analyze3 (String[] array) {
        return () -> Stream.of(array).collect(Collectors.groupingBy((k) -> k, Collectors.counting()));
    }
    public Supplier <Map <String , Long>> analyze4 (String[] array) {
        return () -> Stream.of(array).parallel().collect(Collectors.groupingBy((k) -> k, Collectors.counting()));
    }
}

