package task3;

import java.util.List;

public class StartApp {
    public static void main(String[] args) {
        Data data = new Data();
        CollectionUtils utils = new CollectionUtils();
        System.out.println("Коллекция " + data.getData());
        System.out.println("Сортируем слова коллекции в алфавитном порядке : \n"
                + utils.sortElementsInNaturalOrder(data.getData()));
        System.out.println("Сортируем каждое слово коллекции в алфавитном порядке : ");
        List<String> list = utils.sortWordsCollectionInNaturalOrder(data.getData());
        System.out.println(list);
        System.out.println("Отсортированная коллекция с отсортированными словами");
        System.out.println(utils.sortElementsInNaturalOrder(list));
    }
}
