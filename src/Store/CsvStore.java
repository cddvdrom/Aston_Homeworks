package Store;

import Data.AppData;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;

public class CsvStore implements DataStore{
    private ArrayList <AppData> appDatas;
    private final String extension ="csv";
    private File workDirectory;

    public CsvStore() {
        this.workDirectory =new File(System.getProperty("user.dir")+"\\src\\FileData");
        this.appDatas=new ArrayList<>();
    }

    public String getExtension() {
        return extension;
    }

    public File getWorkDirectory() {
        return workDirectory;
    }

    public void setWorkDirectory(File workDirectory) {
        this.workDirectory = workDirectory;
    }

    @Override
    public void create() {

    }

    @Override
    public void load() {

    }

    @Override
    public void save() {

    }

    @Override
    public void delete() {

    }
    public void loadAppDataFromWorkDir(){

File [] listFiles = workDirectory.listFiles(new FileFilter() {
    @Override
    public boolean accept(File pathname) {
        return !pathname.isDirectory()&&String.valueOf(pathname).endsWith(extension);
    }
});

        for (File file:listFiles
             ) {
           System.out.println(file.toString());
        }
        System.out.println(Arrays.deepToString(workDirectory.list()));


}}
