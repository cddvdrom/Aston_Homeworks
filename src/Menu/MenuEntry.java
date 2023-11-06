package Menu;

public abstract class MenuEntry {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void run();
}
