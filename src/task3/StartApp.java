package task3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StartApp {
    public static void main(String[] args) {
        Data data = new Data();
        System.out.println("Коллекция " + data.getData());
        // Collections.sort(list);
        System.out.println("Сортируем слова коллекции в алфавитном порядке : \n"
                + data.getData().stream().sorted().collect(Collectors.toList()));
        System.out.println("Сортируем каждое слово коллекции в алфавитном порядке : " + "");
        List list = data.getData().stream().map(x -> Arrays.stream(x.split("")).
                        sorted().collect(Collectors.toList())).
                map(x -> x.stream().collect(Collectors.joining())).collect(Collectors.toList());
        System.out.println(list);
        System.out.println("Отсортированная коллекция с отсортированными словами");
        System.out.println(list.stream().sorted().collect(Collectors.toList()));
    }
}
