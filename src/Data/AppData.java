package Data;

import Store.DataStore;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class AppData  {
    private File file;
    private String [] []data;
    private String [] header;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return "AppData{" +
                "file=" + file +
                ", data=" + Arrays.toString(data) +
                ", header=" + Arrays.toString(header) +
                '}';
    }
}
