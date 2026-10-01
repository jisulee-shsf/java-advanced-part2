package reflection.data;

public class BasicData {

    public String publicField;
    private int privateField;

    public BasicData() {
        System.out.println("BasicData.BasicData");
    }

    private BasicData(String data) {
        System.out.println("BasicData.BasicData: " + data);
    }

    public String hello(String str) {
        System.out.println("BasicData.hello");
        return str + " world";
    }
}
