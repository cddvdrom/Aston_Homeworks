package task1.service;
import java.util.*;
public class WordAnalyser {
    public Map<String, Integer> analyse(String[] array) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : array){
            if (!map.containsKey(word)){
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        return map;
    }
}
