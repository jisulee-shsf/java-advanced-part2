package network.tcp.autocloseable;

public class ResourceCloseMainV4 {

    public static void main(String[] args) {
        try {
            logic();
        } catch (CallException e) {
            System.out.println("CallException 예외 처리");
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable throwable : suppressed) {
                System.out.println("suppressedEx: " + throwable);
            }
            e.printStackTrace();
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            e.printStackTrace();
        }
    }

    private static void logic() throws CallException, CloseException {
        try (ResourceV2 resource1 = new ResourceV2("resource1");
             ResourceV2 resource2 = new ResourceV2("resource2")) {
            resource1.call();
            resource2.callEx();
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;
        }
    }
    /*
    resource1 call
    resource2 callEx
    resource2 close
    resource1 close
    ex: network.tcp.autocloseable.CallException: resource2 ex
    CallException 예외 처리
    suppressedEx: network.tcp.autocloseable.CloseException: resource2 ex
    suppressedEx: network.tcp.autocloseable.CloseException: resource1 ex
    network.tcp.autocloseable.CallException: resource2 ex
        at network.tcp.autocloseable.ResourceV2.callEx(ResourceV2.java:17)
        at network.tcp.autocloseable.ResourceCloseMainV4.logic(ResourceCloseMainV4.java:25)
        at network.tcp.autocloseable.ResourceCloseMainV4.main(ResourceCloseMainV4.java:7)
        Suppressed: network.tcp.autocloseable.CloseException: resource2 ex
            at network.tcp.autocloseable.ResourceV2.close(ResourceV2.java:23)
            at network.tcp.autocloseable.ResourceCloseMainV4.logic(ResourceCloseMainV4.java:22)
            ... 1 more
        Suppressed: network.tcp.autocloseable.CloseException: resource1 ex
            at network.tcp.autocloseable.ResourceV2.close(ResourceV2.java:23)
            at network.tcp.autocloseable.ResourceCloseMainV4.logic(ResourceCloseMainV4.java:22)
            ... 1 more
    */
}
