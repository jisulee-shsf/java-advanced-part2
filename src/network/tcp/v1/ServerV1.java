package network.tcp.v1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class ServerV1 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        Socket socket = serverSocket.accept();
        log("소켓 연결: " + socket);

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        String received = dataInputStream.readUTF();
        log("client -> server: " + received);

        String toSend = received + " World!";
        dataOutputStream.writeUTF(toSend);
        log("client <- server: " + toSend);

        log("연결 종료: " + socket);
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
        serverSocket.close();
        /*
        00:55:02.758 [     main] 서버 시작
        00:55:02.770 [     main] 서버 소켓 시작 - 리스닝 포트: 12345
        00:55:10.401 [     main] 소켓 연결: Socket[addr=/127.0.0.1,port=49597,localport=12345]
        00:55:10.404 [     main] client -> server: Hello
        00:55:10.407 [     main] client <- server: Hello World!
        00:55:10.408 [     main] 연결 종료: Socket[addr=/127.0.0.1,port=49597,localport=12345]
        */
    }
}
