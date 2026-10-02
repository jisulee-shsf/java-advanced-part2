package annotation.inherited;

import java.lang.annotation.Annotation;

public class InheritedMain {

    public static void main(String[] args) {
        print(Parent.class);
        print(Child.class);
        print(TestInterface.class);
        print(TestInterfaceImpl.class);
    }

    private static void print(Class<?> clazz) {
        System.out.println("class: " + clazz);
        for (Annotation annotation : clazz.getAnnotations()) {
            System.out.println("- " + annotation.annotationType().getSimpleName());
        }
        System.out.println();
    }
    /*
    class: class annotation.inherited.Parent
    - InheritedAnnotation
    - NoInheritedAnnotation

    class: class annotation.inherited.Child
    - InheritedAnnotation

    class: interface annotation.inherited.TestInterface
    - InheritedAnnotation
    - NoInheritedAnnotation

    class: class annotation.inherited.TestInterfaceImpl
    */
}
