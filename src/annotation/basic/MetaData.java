package annotation.basic;

import java.lang.annotation.Annotation;

@AnnoMeta
public class MetaData {

    //    @AnnoMeta
    private String id;

    @AnnoMeta
    public void call() {
    }

    public static void main(String[] args) throws NoSuchMethodException {
        AnnoMeta typeAnno = MetaData.class.getAnnotation(AnnoMeta.class);
        System.out.println(typeAnno); // @annotation.basic.AnnoMeta()

        Annotation methodAnno = MetaData.class.getMethod("call").getAnnotation(AnnoMeta.class);
        System.out.println(methodAnno); // @annotation.basic.AnnoMeta()
    }
}
