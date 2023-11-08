package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputDataService implements InputData{
    private BufferedReader reader;
    private boolean exit;

    public InputDataService(){
        this.reader=new BufferedReader(new InputStreamReader(System.in));
        this.exit=false;
    }
    @Override
    public String input() {
        String line;
        try {
            line = reader.readLine();
            return line;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
