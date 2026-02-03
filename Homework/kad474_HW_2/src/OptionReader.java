import java.util.*;

public class OptionReader {
	private static HashMap<String, String> userOptions = null;
	private static final KWICObjectLoader kwicObjLoader = new KWICObjectLoader();
	
	private OptionReader() {
	}
	
	public static void readOptions() {
		ResourceBundle rb = ResourceBundle.getBundle("config");
		Enumeration<String> keys = rb.getKeys();
		userOptions = new HashMap<String, String>();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = rb.getString(key);
			userOptions.put(key, value);
		}
	}
	
	public static Object getObjectFromKey(String keyStr) { 
		if (!userOptions.containsKey(keyStr)) {
			return null;
		}
	
		// First lookup (Input -> TxtInputObj)
		String objKey = userOptions.get(keyStr);
	
		// Second lookup (TxtInputObj -> TxtIn)
		if (!userOptions.containsKey(objKey)) {
			throw new RuntimeException("Class mapping not found for: " + objKey);
		}
	
		String className = userOptions.get(objKey);
	
		// Load actual class
		return kwicObjLoader.loadObject(className);
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
