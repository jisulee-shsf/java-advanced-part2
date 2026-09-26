package network.tcp.autocloseable;

public class ResourceCloseMainV3 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            e.printStackTrace();
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            e.printStackTrace();
        }
    }

    private static void logic() throws CallException, CloseException {
        ResourceV1 resource1 = null;
        ResourceV1 resource2 = null;
        try {
            resource1 = new ResourceV1("resource1");
            resource2 = new ResourceV1("resource2");

            resource1.call();
            resource2.callEx();
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        } finally {
            if (resource2 != null) {
                try {
                    resource2.closeEx();
                } catch (CloseException e) {
                    System.out.println("close ex: " + e);
                }
            }
            if (resource1 != null) {
                try {
                    resource1.closeEx();
                } catch (CloseException e) {
                    System.out.println("close ex: " + e);
                }
            }
        }
    }
    /*
    resource1 call
    resource2 callEx
    ex: network.tcp.autocloseable.CallException: resource2 ex
    resource2 closeEx
    close ex: network.tcp.autocloseable.CloseException: resource2 ex
    resource1 closeEx
    close ex: network.tcp.autocloseable.CloseException: resource1 ex
    CallException 예외 처리
    network.tcp.autocloseable.CallException: resource2 ex
        at network.tcp.autocloseable.ResourceV1.callEx(ResourceV1.java:17)
        at network.tcp.autocloseable.ResourceCloseMainV3.logic(ResourceCloseMainV3.java:25)
        at network.tcp.autocloseable.ResourceCloseMainV3.main(ResourceCloseMainV3.java:7)
     */
}
