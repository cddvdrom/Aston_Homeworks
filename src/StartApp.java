public class StartApp {
    public static void main(String[] args) {
        System.out.println("Приложение стартовало");
        Box <Apple> box = new Box <> ();
        Box <Orange> box2 = new Box <> ();

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();

        box.addFruit(apple1);
        box.addFruit(apple2);
        box.addFruit(apple3);

        box2.addFruit(orange1);
        box2.addFruit(orange2);
        box2.addFruit(orange3);

        System.out.println(box.getList());

    }
}
