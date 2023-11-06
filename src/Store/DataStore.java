package Store;

import java.io.File;

public interface DataStore {
    void create();
    void load();
    void save();
    void delete();
    void setWorkDirectory(File file);
     void loadAppDataFromWorkDir();
     File getWorkDirectory();

}
