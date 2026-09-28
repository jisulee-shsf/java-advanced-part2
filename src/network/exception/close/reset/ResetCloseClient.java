package network.exception.close.reset;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketException;

import static util.MyLogger.log;

public class ResetCloseClient {

    public static void main(String[] args) throws IOException, InterruptedException {
        Socket socket = new Socket("localhost", 12345);
        log("소켓 연결: " + socket);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        Thread.sleep(1000);

        outputStream.write(1);

        Thread.sleep(1000);

        try {
            // java.net.SocketException: Connection reset
            int read = inputStream.read();
            System.out.println("read = " + read);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        try {
            // java.net.SocketException: Broken pipe
            outputStream.write(1);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
