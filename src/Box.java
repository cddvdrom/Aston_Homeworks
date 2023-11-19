import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {
    private ArrayList <T> fruits;
    public Box() {
        fruits=new ArrayList<>();
    }

    public void addFruit(T...fruit) {
        fruits.add((T) Arrays.asList(fruit));
    }
    public void addFruit (T fruit,int n){
        for (int i=0;i<n;i++){fruits.add(fruit);}
    }
    public double getWeight() {
        if (fruits.size()==0){return 0f;}
        return fruits.size()*fruits.get(0).getWeight();
    }

    public boolean compare(Box<Orange> box) {
        return this.getWeight() == box.getWeight();
    }

    public void move(Box<? super T> box) {

    }
}
