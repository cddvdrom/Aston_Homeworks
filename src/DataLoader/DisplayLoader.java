package DataLoader;

import Display.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;
import java.util.Properties;

public class DisplayLoader {
    public Display load() {
        File file = new File("src/file.properties");
        if (file.exists()) {
            try {
                Properties props = new Properties();
                props.load(new FileInputStream(file));
                String display = "display";
                String value = "";
                for (Object key : props.keySet()) {

                    if (Objects.equals(key, display)) {
                        value = (String) props.get(key);
                    }
                }
                if (Objects.equals(value, "console")) {
                    return new ConsoleDisplay();
                } else {
                    throw new RuntimeException("не определен метод вывода");
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