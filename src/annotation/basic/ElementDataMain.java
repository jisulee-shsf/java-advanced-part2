package annotation.basic;

import java.util.Arrays;

public class ElementDataMain {

    public static void main(String[] args) {
        Class<ElementData> annoClass = ElementData.class;
        AnnoElement annotation = annoClass.getAnnotation(AnnoElement.class);

        String value = annotation.value();
        System.out.println(value); // data

        int count = annotation.count();
        System.out.println(count); // 10

        String[] tags = annotation.tags();
        System.out.println(Arrays.toString(tags)); // [t1, t2]
    }
}
