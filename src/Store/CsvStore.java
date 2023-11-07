package Store;

import Menu.FileMenuData;

import java.io.*;
import java.util.ArrayList;


public class CsvStore implements DataStore {

    private final String extension = "csv";
    private File workDirectory;

    public CsvStore() {
        this.workDirectory = new File(System.getProperty("user.dir") + "\\src\\FileData");


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
    public ArrayList<String> load(File file) {
        FileReader reader = null;
        try {
            reader = new FileReader(file);

            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            ArrayList<String> lines = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            return lines;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void save() {

    }

    @Override
    public void delete(File file) {
        if (file.exists()) file.delete();
    }

    public FileMenuData loadAppDataFromWorkDir() {

        File[] paths = workDirectory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.isDirectory() && String.valueOf(pathname).endsWith(extension);
            }
        });
        String[] names = workDirectory.list();
        return new FileMenuData(paths, names);

    }
}
