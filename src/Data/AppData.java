package Data;


import java.util.Arrays;

public class AppData  {
    private String [] []data;
    private String [] header;

public AppData(int values,int lines){
    this.data=new String[lines-1][values];
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
    StringBuilder stringBuilder=new StringBuilder();
    String header=String.join(";",getHeader())+";";
    stringBuilder.append(header+"\n");
    for(int i=0;i<data.length;i++){
            String data=String.join(";",getData()[i]);
            stringBuilder.append(data+";\n");
    }

        return stringBuilder.toString();
    }
}
