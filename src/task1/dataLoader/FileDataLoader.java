package task1.dataLoader;

import java.io.*;
import java.util.Properties;

public class FileDataLoader {
    public String load() {
        Properties properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("file.properties");
        try {
            properties.load(stream);
            File file = new File(properties.getProperty("file"));
            if (file.exists()) {
                String result = "";
                BufferedReader reader = new BufferedReader(new FileReader(file));
                result = reader.readLine();
                return result;
            } else {
                throw new FileNotFoundException("файл данных не найден");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
