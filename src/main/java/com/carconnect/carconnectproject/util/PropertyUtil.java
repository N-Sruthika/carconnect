package com.carconnect.carconnectproject.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
    private static Properties properties = new Properties();

    static {
        try (FileInputStream inputStream = new FileInputStream("db.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            System.err.println("Failed to load properties file: " + e.getMessage());
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }
}
