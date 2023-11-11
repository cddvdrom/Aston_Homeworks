package task1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
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
                System.out.println(file.getName());
            } else {
                throw new FileNotFoundException("файл данных не найден");
            }
            String result = "";
            BufferedReader reader = new BufferedReader(new FileReader(file));
            result = reader.readLine();
            return result;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
