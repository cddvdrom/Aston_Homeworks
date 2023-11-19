public class StartApp {
    public static void main(String[] args) {
        System.out.println("Приложение стартовало");
        Box <Apple> box = new Box <> ();
        Box <Orange> box2 = new Box <> ();

        box.addFruit(new Apple(),5);

        box2.addFruit(new Orange(),5);

        System.out.println(box.getWeight());

        System.out.println(box2.getWeight());

        System.out.println(box.compare(box2));
    }
}
