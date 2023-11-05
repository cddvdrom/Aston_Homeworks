package task1.View;

import task1.Result.Result;

public class ConsoleDisplay implements Display {
    @Override
    public void show(Result result) {
    System.out.println(result.getMessage()+"\n");
    }
}
