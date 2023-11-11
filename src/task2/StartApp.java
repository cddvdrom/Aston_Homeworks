package task2;

import task1.FileDataLoader;

public class StartApp {
    public static void main(String[] args) {
        String data=new FileDataLoader().load();
        System.out.println(data);
    }
}
