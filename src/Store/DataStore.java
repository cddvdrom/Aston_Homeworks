package Store;

import Menu.FileMenuData;

import java.io.File;
import java.util.ArrayList;

public interface DataStore {
    void create();
    ArrayList<String> load(File file);
    void save();
    void delete(File file);
    void setWorkDirectory(File file);
     FileMenuData loadAppDataFromWorkDir();
     File getWorkDirectory();

}
