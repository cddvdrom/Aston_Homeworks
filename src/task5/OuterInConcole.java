package task5;

import java.util.List;

public class OuterInConcole {
    public void printList(List<String> list) {
        if (list.size() == 0) {
            System.out.println("Требуемых данных не вводилось");
        } else {
            list.forEach(System.out::println);
            }
        }
    }

