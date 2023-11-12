package task1;

import task1.dataLoader.FileDataLoader;
import task1.service.Converter;
import task1.service.DisplayOutput;
import task1.service.WordAnalyser;

public class StartApp {
    public static void main(String[] args) {
        Converter converter = new Converter();
        FileDataLoader loader=new FileDataLoader();
        String data=loader.load();
        String[] dataArr = converter.getArrayFromString(data);
        WordAnalyser analyser=new WordAnalyser();
        new DisplayOutput().show(analyser.analyse(dataArr));
    }
}
