package task2.Entity;

public enum FigureType {
    CIRCLE("Окружность"),
    OVAL("Овал"),
    TRIANGLE("Треугольник"),
    HEXAGON("Шестиуголник"),
    OCTAGON("Восьмиугольник"),
    DIAMOND("Ромб"),
    RECTANGLE("Прямоугольник"),
    SQUARE("Квадрат");
    private final String name;

    FigureType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
