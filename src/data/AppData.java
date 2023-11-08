package data;


public class AppData  {
    private String [] []data;
    private String [] header;

public AppData(int column,int lines){
    this.data=new String[lines-1][column];
    this.header=new String[column];
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
    for(int i=0;i<data.length;i++)
    {
            String data=String.join(";",getData()[i]);
            stringBuilder.append(data+";\n");
    }

        return stringBuilder.toString();
    }
}
