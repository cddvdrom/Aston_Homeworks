package task2;

import task1.dataLoader.FileDataLoader;
import task1.service.Converter;
import task1.service.DisplayOutput;
import task1.service.WordAnalyser;


public class StartApp {
    public static void main(String[] args) {
        String[] dataArr = new Converter().getArrayFromString(new FileDataLoader().load());
        new DisplayOutput().show(new WordAnalyser().analyse(dataArr));
    }
}
