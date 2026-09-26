package network.tcp.v2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class ServerV2 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        Socket socket = serverSocket.accept();
        log("소켓 연결: " + socket);

        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

        while (true) {
            String received = dataInputStream.readUTF();
            log("client -> server: " + received);

            if (received.equals("exit")) {
                break;
            }

            String toSend = received + " World!";
            dataOutputStream.writeUTF(toSend);
            log("client <- server = " + toSend);
        }

        log("연결 종료: " + socket);
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
        serverSocket.close();
        /*
        03:29:28.189 [     main] 서버 시작
        03:29:28.197 [     main] 서버 소켓 시작 - 리스닝 포트: 12345
        03:29:32.557 [     main] 소켓 연결: Socket[addr=/127.0.0.1,port=49842,localport=12345]
        03:30:16.246 [     main] client -> server: Hello
        03:30:16.249 [     main] client <- server = Hello World!
        03:30:31.062 [     main] client -> server: exit
        03:30:31.063 [     main] 연결 종료: Socket[addr=/127.0.0.1,port=49842,localport=12345]
        */
    }
}
