package task1.service;

import java.util.*;

public class DisplayOutput {
    public void show(Map<String, Integer> map) {
        Set<String> keys = map.keySet();
        List<String> list = new ArrayList<>(keys);
        Collections.sort(list);

        System.out.println("-----------------------------------------------------");
        System.out.print(String.format("|%-3s|%-25s | %-22s |\n","id", "Слово", "Количество повторений"));
        System.out.println("-----------------------------------------------------");
        int counter=1;
        for (String value : list
        ) {
            System.out.print(String.format("|%-3s|%-25s | %22s |\n",counter++, value, map.get(value.toString())));

        }
        System.out.println("-----------------------------------------------------");
        System.out.println("");
        System.out.print(String.format("%-25s  %-22s \n", "Общее количествово уникальных слов", keys.size()));
    }
}
