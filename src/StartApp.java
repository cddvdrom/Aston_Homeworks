public class StartApp {
    public static void main(String[] args) {
        System.out.println("Приложение стартовало");
        Box <Apple> box = new Box <> ();
        Box <Orange> box2 = new Box <> ();

        box.addFruit(new Apple(),6);

        box2.addFruit(new Orange(),4);

        Box <Apple> box3 = new Box<>();

        System.out.println(box.getFruits());
        System.out.println(box.getWeight());
        System.out.println(box2.getFruits());
        System.out.println(box2.getWeight());

        System.out.println(box.compare(box2));

        box.move(box3);
        System.out.println(box);
        System.out.println(box3);
    }
}
