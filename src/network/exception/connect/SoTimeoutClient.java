package network.exception.connect;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SoTimeoutClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        InputStream inputStream = socket.getInputStream();

        try {
            socket.setSoTimeout(3000);
            int read = inputStream.read();
            System.out.println("read = " + read);
        } catch (Exception e) {
            e.printStackTrace();
        }
        socket.close();
    }
    /*
    java.net.SocketTimeoutException: Read timed out
	at java.base/sun.nio.ch.NioSocketImpl.timedRead(NioSocketImpl.java:278)
	at java.base/sun.nio.ch.NioSocketImpl.implRead(NioSocketImpl.java:304)
	at java.base/sun.nio.ch.NioSocketImpl.read(NioSocketImpl.java:346)
	at java.base/sun.nio.ch.NioSocketImpl$1.read(NioSocketImpl.java:796)
	at java.base/java.net.Socket$SocketInputStream.read(Socket.java:1099)
	at java.base/java.net.Socket$SocketInputStream.read(Socket.java:1093)
	at network.exception.connect.SoTimeoutClient.main(SoTimeoutClient.java:15)
    */
}
