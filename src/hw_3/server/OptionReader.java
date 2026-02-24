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
    try (FileInputStream fis = new FileInputStream(filename)) {
        Properties props = new Properties();
        props.load(fis);

        for (String key : props.stringPropertyNames()) {
            userOptions.put(key, props.getProperty(key));
        }
    } catch (IOException e) {
        throw new RuntimeException("Failed to load config file: " + filename, e);
    }
}

	
	public static Object getObjectFromKey(String keyStr) { 
		Object kwicObj = null;
		if (userOptions.containsKey(keyStr)) {
			String objName;
			objName = userOptions.get(keyStr);
			kwicObj = kwicObjLoader.loadObject(objName);
		}
		return kwicObj;
	}
	
	public static Object getObjectFromStr(String objStr) {
		return kwicObjLoader.loadObject(objStr);
	}
	
	public static String getString(String keyStr) {
		String valueStr = "";
		if (userOptions.containsKey(keyStr)) {			
			valueStr = userOptions.get(keyStr);			
		}
		return valueStr;
	}
	
	
	

}
