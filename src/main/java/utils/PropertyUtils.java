package utils;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    public static String getProperty(String file, String property) {
        FileInputStream fileInputStream;
        Properties properties = new Properties();
        try {
            fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(property);
    }
}