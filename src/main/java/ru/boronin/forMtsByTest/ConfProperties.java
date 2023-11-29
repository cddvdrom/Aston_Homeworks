package ru.boronin.forMtsByTest;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class ConfProperties {
    public final Properties PROPERTIES = new Properties();

public ConfProperties () {
    try (
        InputStreamReader inputStreamReader = new InputStreamReader(
                new FileInputStream("src/test/resources/conf.properties"), StandardCharsets.UTF_8)
        )
    {
        PROPERTIES.load(inputStreamReader);
    }
    catch (IOException e) {
        throw new RuntimeException(e);
    }


}
    public String getProperty (String key) {
        return PROPERTIES.getProperty(key); }
}

