
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class KWICObjectLoader extends ClassLoader {

	public Object loadObject(String className) {
     
        try {
            // Create a new ClassLoader 
            ClassLoader loader = this.getClass().getClassLoader();
		
            // Load the target class using its name
            @SuppressWarnings("rawtypes")
            Class aClass = loader.loadClass(className);

            // Create a new instance from the loaded class
            @SuppressWarnings("rawtypes")
            Constructor constructor = aClass.getConstructor();
            Object obj = constructor.newInstance();

            //return the instance
            return obj;

		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new RuntimeException("Failed to create instance of: " + className, e);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Class not found: " + className, e);
		} catch (NoSuchMethodException | SecurityException e) {
            throw new RuntimeException("No default constructor for: " + className, e);
		}

	}

}
