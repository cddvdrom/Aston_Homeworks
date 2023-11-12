package task1.dataLoader;
import java.io.*;
import java.util.Properties;
public class FileDataLoader {
    public String load() {
        Properties properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream stream = loader.getResourceAsStream("\\task1\\file.properties"))
        {
            properties.load(stream);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        File file = new File(properties.getProperty("file"));
        if (file.exists())
        {
            String result;
            try (BufferedReader reader = new BufferedReader(new FileReader(file)))
            {
                result = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return result;
        } else
        {
            try
            {
                throw new FileNotFoundException("файл данных не найден");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
