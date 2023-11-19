import java.util.Objects;

public abstract class Fruit {
    private final String name;
    private final float weight;

    protected Fruit(String name,Float weight) {
        this.name = name;
        this.weight=weight;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }


}
