package ru.boronin.utils;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

public class Utils {
    public int stringToInt(String string) {
        return Integer.parseInt(string.replaceAll("[^0-9]", "").replaceAll(" ", ""));
    }
    public List<Map.Entry<String, String>> castNames(List<Map.Entry<String, String>> actualEntries,
                                                     List<Map.Entry<String, String>> expectedEntries) {
        for (int j = 0; j < expectedEntries.size() - 1; j++) {
            if (expectedEntries.get(j).getKey().toLowerCase().
                    contains(actualEntries.get(j).getKey().toLowerCase())) {
                expectedEntries.set(j,
                        new AbstractMap.SimpleEntry<>(actualEntries.get(j).getKey(), actualEntries.get(j).getValue()));
            }
        }
        return expectedEntries;
    }
    public int getSumFromProductList (List<Map.Entry<String, String>> list) {
        int sum = 0;
        for (Map.Entry <String, String> m : list) {
            String a = m.getValue();
            sum+= stringToInt(a);
        }
        return sum;
    }
}
