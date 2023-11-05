package task2.Entity;

public enum Colors {
    RED("красный"),
    BLACK("черный"),
    WHITE("белый"),
    BLUE("синий"),
    GREEN("зеленый"),
    YELLOW("желтый"),
    ORANGE("оранжевый");

    private final String color;

    Colors(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    ;
}
