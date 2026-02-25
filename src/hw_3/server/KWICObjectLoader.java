package src.hw_3.server;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class KWICObjectLoader extends ClassLoader {

    private static final String[] PACKAGE_PREFIXES = {
        "src.hw_3.server.",
        "src.hw_3.client."
    };

    public Object loadObject(String className) {

        for (String prefix : PACKAGE_PREFIXES) {
            String fullName = prefix + className;

            try {
                ClassLoader loader = this.getClass().getClassLoader();
                Class<?> aClass = loader.loadClass(fullName);

                Constructor<?> constructor = aClass.getConstructor();
                return constructor.newInstance();

            } catch (ClassNotFoundException e) {
                // Try next package
            } catch (InstantiationException | IllegalAccessException |
                     IllegalArgumentException | InvocationTargetException |
                     NoSuchMethodException | SecurityException e) {
                throw new RuntimeException("Failed to create instance of: " + fullName, e);
            }
        }

        throw new RuntimeException("Class not found in server or client packages: " + className);
    }
}

