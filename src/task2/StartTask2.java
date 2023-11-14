package task2;

import java.util.List;
public class StartTask2 {
    public static void main(String[] args) {
        Data data = new Data();
        CollectionUtil util = new CollectionUtil();
        List <String> list = data.getData();
        System.out.println( "Коллекция : "+ list );
        System.out.print( "Количество повторений объекта High : ");
   //   int count = Collections.frequency(list,"High");
        Long count = list.stream().filter( x -> x.equals("High") ).count();
        System.out.println(count);
        System.out.print( "Количество вхождений объекта High : ");
        Long result = list.stream().filter( x -> x.contains("High") ).count();
        System.out.println(result);
        System.out.println("Первый элемент коллекции = " + util.getFirst(list));
        System.out.println("Первый элемент коллекции = " + util.getLast(list));
    }
}
