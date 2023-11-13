package task1;

import java.util.List;
public class StartTask1 {
    public static void main(String[] args) {
        GeneratorRandom generator = new GeneratorRandom();
        List <Integer>list = generator.generateList();
        System.out.println ("Случайные числа : " + list);
        System.out.println ("Общее количество чисел = " + list.size());
        System.out.print ("Количество положительных = ");
        Long count = list.stream().filter( x -> x%2==0 ).count();
        System.out.print(count);
    }
}
