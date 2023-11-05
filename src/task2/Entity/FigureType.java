package task2.Entity;

public enum FigureType {
    CIRCLE("Окружность"),
    OVAL("Овал"),
    TRIANGLE(""),
    HEXAGON(""),
    OCTAGON(""),
    DIAMOND(""),
    RECTANGLE(""),
    SQUARE("");
    private final String name;

    FigureType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
