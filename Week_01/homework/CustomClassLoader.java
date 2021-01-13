import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

class CustomClassLoader extends ClassLoader {

    public static void main(String[] args) {
        try {
            Object obj = new CustomClassLoader().findClass("Hello").getDeclaredConstructor().newInstance();
            Method f = obj.getClass().getMethod("hello");
            f.invoke(obj);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] bytesIn = Files.readAllBytes(Paths.get("Hello.xlass"));
            for (int i = 0; i < bytesIn.length; i++) {
                bytesIn[i] = (byte) (255 - bytesIn[i]);
            }
            return defineClass("Hello", bytesIn, 0, bytesIn.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}