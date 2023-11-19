import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList <T> list;


    public Box() {
            this.list = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        list.add(fruit);
    }

    public ArrayList<T> getList() {
        return list;
    }

    public double getWeight() {
        return (float) list.stream().mapToDouble(x -> x.getWeight()).sum();
    }
}
