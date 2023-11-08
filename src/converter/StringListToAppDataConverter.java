package converter;

import data.AppData;

import java.util.ArrayList;

public class StringListToAppDataConverter {
    public AppData convert (ArrayList <String> lines ){
        AppData appData=new AppData(lines.get(0).split(";").length,lines.size());
        appData.setHeader(lines.get(0).split(";"));
       for (int i=1;i<lines.size();i++){
                     appData.getData()[i-1]=lines.get(i).split(";");
       }

        return appData;
    }
}
