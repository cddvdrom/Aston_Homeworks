package ru.boronin.forYandexTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfProperties {
    public final Properties PROPERTIES = new Properties();

public ConfProperties () {
        try (FileInputStream fileInputStream = new FileInputStream("src/test/resources/conf.properties"))
    {
            PROPERTIES.load(fileInputStream);
    } catch (IOException e) {
            throw new RuntimeException(e);
        }
}
    public String getProperty (String key) {
        return PROPERTIES.getProperty(key); }
}

