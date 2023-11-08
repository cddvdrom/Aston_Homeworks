package store;

import java.io.File;
import java.util.ArrayList;

public interface DataStore {
    ArrayList<String> load(File file);
    void save(File file,ArrayList <String>list);
    void delete(File file);
    void setWorkDirectory(File file);
     FileMenuData loadAppDataFromWorkDir();
     File getWorkDirectory();

}
