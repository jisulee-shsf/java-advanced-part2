package annotation.mapping;

public class TestController {

    @SimpleAnnotation(value = "/")
    public void home() {
        System.out.println("TestController.home");
    }

    @SimpleAnnotation(value = "/site1")
    public void page1() {
        System.out.println("TestController.page1");
    }
}
