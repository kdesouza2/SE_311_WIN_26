package src.hw_3.server;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class OptionReader {
    private static HashMap<String, String> userOptions = null;
    private static final KWICObjectLoader kwicObjLoader = new KWICObjectLoader();

    private OptionReader() {
    }

    public static void readOptions(String filename) {
        userOptions = new HashMap<>();

        Properties props = new Properties();

        try (FileInputStream fis = new FileInputStream(filename)) {
            props.load(fis);

            for (String key : props.stringPropertyNames()) {
                userOptions.put(key, props.getProperty(key));
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file: " + filename, e);
        }
    }

    public static Object getObjectFromKey(String keyStr) {
        if (userOptions.containsKey(keyStr)) {
            String objName = userOptions.get(keyStr);
            return kwicObjLoader.loadObject(objName);
        }
        return null;
    }

    public static Object getObjectFromStr(String objStr) {
        return kwicObjLoader.loadObject(objStr);
    }

    public static String getString(String keyStr) {
        return userOptions.getOrDefault(keyStr, "");
    }
}
