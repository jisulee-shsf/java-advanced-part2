package network.tcp.v2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static util.MyLogger.log;

public class ClientV2 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("클라이언트 시작");

        Socket socket = new Socket("localhost", PORT);
        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        log("소켓 연결: " + socket);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("전송 문자: ");
            String toSend = scanner.nextLine();

            dataOutputStream.writeUTF(toSend);
            log("client -> server: " + toSend);

            if (toSend.equals("exit")) {
                break;
            }

            String received = dataInputStream.readUTF();
            log("client <- server: " + received);
        }

        log("연결 종료: " + socket);
        dataInputStream.close();
        dataOutputStream.close();
        socket.close();
        /*
        03:29:32.530 [     main] 클라이언트 시작
        03:29:32.557 [     main] 소켓 연결: Socket[addr=localhost/127.0.0.1,port=12345,localport=49842]
        전송 문자: Hello
        03:30:16.246 [     main] client -> server: Hello
        03:30:16.249 [     main] client <- server: Hello World!
        전송 문자: exit
        03:30:31.062 [     main] client -> server: exit
        03:30:31.062 [     main] 연결 종료: Socket[addr=localhost/127.0.0.1,port=12345,localport=49842]
        */
    }
}
