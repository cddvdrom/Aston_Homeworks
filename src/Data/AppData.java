package Data;


import java.util.Arrays;

public class AppData  {
    private String [] []data;
    private String [] header;

public AppData(int values,int lines){
    this.data=new String[lines][values];
    this.header=new String[values];
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
                ", data=" + Arrays.toString(data) +
                ", header=" + Arrays.toString(header) +
                '}';
    }
}
