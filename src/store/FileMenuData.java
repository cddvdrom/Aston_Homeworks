package store;

import java.io.File;

public class FileMenuData {
    private File[] paths;
    private String [] names;

    public FileMenuData(File [] paths, String [] names){
        this.paths=paths;
        this.names=names;
    }
    public File[] getPaths() {
        return paths;
    }
    public String[] getNames() {
        return names;
    }
}
