package Converter;

import Data.AppData;

import java.util.ArrayList;

public class StringListToAppDataConverter {
    public AppData convert (ArrayList <String> lines ){
        AppData appData=new AppData(lines.get(0).split(";").length,lines.size());
       for (int i=0;i<lines.size();i++){
           if (i==0){appData.setHeader(lines.get(i).split(";"));}
           appData.getData()[i]=lines.get(i).split(";");
       }

        return appData;
    }
}
