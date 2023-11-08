package display;

public class ConsoleDisplay implements Display{
    @Override
    public void show(String line) {
        System.out.println(line);
    }
}
