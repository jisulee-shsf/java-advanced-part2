package was.v3;

import was.v2.HttpServerV2;

import java.io.IOException;

public class HttpServerMainV3 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        HttpServerV3 httpServer = new HttpServerV3(PORT);
        httpServer.start();
    }
}
