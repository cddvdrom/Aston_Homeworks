public class StartApp {
    public static void main(String[] args) {
        Box <Apple> box = new Box <> ();
        Box <Orange> box2 = new Box <> ();
        Box <Apple> box3 = new Box <> ();
        box.addFruit (new Apple(),6);
        box2.addFruit(new Orange(),4);
        System.out.println(box);
        System.out.println(box2);
        System.out.println(box.compare(box2));
        box.move(box3);
        System.out.println(box);
        System.out.println(box3);
    }
}
