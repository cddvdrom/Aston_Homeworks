package dataLoader;

import store.CsvStore;

import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

public class FileTypeLoader {
    public CsvStore load() {
        File file = new File("src/file.properties");
        if (file.exists())
        {
            try {
                Properties props = new Properties();
                props.load(new FileInputStream(file));
                String display = "fileType";
                String value = "";
                for (Object key : props.keySet())
                {

                    if (Objects.equals(key, display))
                    {
                        value = (String) props.get(key);
                    }
                }
                if (Objects.equals(value, "csv"))
                {
                    return new CsvStore();
                } else {
                    throw new RuntimeException("не определен формат данных");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not found");
        }
        return null;
    }
}
