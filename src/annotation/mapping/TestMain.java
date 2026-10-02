package annotation.mapping;

import java.lang.reflect.Method;

public class TestMain {

    public static void main(String[] args) {
        TestController testController = new TestController();

        Class<? extends TestController> aClass = testController.getClass();
        for (Method method : aClass.getDeclaredMethods()) {
            SimpleAnnotation annotation = method.getAnnotation(SimpleAnnotation.class);
            if (annotation != null) {
                System.out.println("[" + annotation.value() + "] " + method);
            }
        }
    }
    /*
    [/site1] public void annotation.mapping.TestController.page1()
    [/] public void annotation.mapping.TestController.home()
    */
}
