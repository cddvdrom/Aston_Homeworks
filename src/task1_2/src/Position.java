public enum Position {
    DIRECTOR("директор"),
    ACCOUNTANT("бухгалтер"),
    TECHNOLOGIST("технолог"),
    MANAGER("менеджер"),
    CASHIER("кассир");

    private String name;

    Position(String name) {
        this.name = name;
    }

    public String getNameOfPosition() {
        return name;
    }
}
