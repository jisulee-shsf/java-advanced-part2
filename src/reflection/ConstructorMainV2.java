package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ConstructorMainV2 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> aClass = Class.forName("reflection.data.BasicData");
        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);

        declaredConstructor.setAccessible(true);
        Object instance = declaredConstructor.newInstance("hello");

        Method method = aClass.getMethod("hello", String.class);
        Object result = method.invoke(instance, "hello");
        System.out.println(result);
        /*
        BasicData.BasicData: hello
        BasicData.hello
        hello world
        */
    }
}
