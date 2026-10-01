package reflection;

import java.lang.reflect.Constructor;

public class ConstructorMainV1 {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("reflection.data.BasicData");

        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        // public reflection.data.BasicData()

        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        /*
        public reflection.data.BasicData()
        private reflection.data.BasicData(java.lang.String)
        */
    }
}
