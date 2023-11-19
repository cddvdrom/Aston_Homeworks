public abstract class Fruit<T> {
    private final String name;
    private final float weight;

    protected Fruit(String name,Float weight) {
        this.name = name;
        this.weight=weight;
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
