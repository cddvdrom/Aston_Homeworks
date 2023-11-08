package converter;

import data.AppData;

import java.util.ArrayList;

public class AppDataToStringListConverter {
    public ArrayList <String> convert(AppData appData){
        ArrayList <String> lines=new ArrayList<>();
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<appData.getHeader().length;i++){
                stringBuilder.append(appData.getHeader()[i]);
                stringBuilder.append(";");
        }
        lines.add(stringBuilder.toString());
        for (int i=0;i<appData.getData().length;i++){
           stringBuilder.setLength(0);
           for(int j=0;j<appData.getData()[i].length;j++){
               stringBuilder.append(appData.getData()[i][j]);
               stringBuilder.append(";");
           }
           lines.add(stringBuilder.toString());
        }
        return lines;
    };

}
