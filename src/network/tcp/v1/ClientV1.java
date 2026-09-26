package network.tcp.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static util.MyLogger.log;

public class ClientV1 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");

        Socket socket = new Socket("localhost", PORT);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        log("소켓 연결: " + socket);

        String toSend = "Hello";
        dataOutputStream.writeUTF(toSend);
        log("client -> server: " + toSend);

        String received = dataInputStream.readUTF();
        log("client <- server: " + received);

        log("연결 종료: " + socket);
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
        /*
        00:55:10.361 [     main] 클라이언트 시작
        00:55:10.399 [     main] 소켓 연결: Socket[addr=localhost/127.0.0.1,port=12345,localport=49597]
        00:55:10.402 [     main] client -> server: Hello
        00:55:10.407 [     main] client <- server: Hello World!
        00:55:10.408 [     main] 연결 종료: Socket[addr=localhost/127.0.0.1,port=12345,localport=49597]
        */
    }
}
