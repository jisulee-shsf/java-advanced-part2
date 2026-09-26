package network.tcp.v3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import static util.MyLogger.log;

public class ClientV3 {

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
    }
    /*
    05:43:33.271 [     main] 클라이언트 시작
    05:43:33.298 [     main] 소켓 연결: Socket[addr=localhost/127.0.0.1,port=12345,localport=50076]
    전송 문자: Hello
    05:43:43.517 [     main] client -> server: Hello
    05:43:43.520 [     main] client <- server: Hello World!
    전송 문자: exit
    05:44:03.804 [     main] client -> server: exit
    05:44:03.805 [     main] 연결 종료: Socket[addr=localhost/127.0.0.1,port=12345,localport=50076]
    */

    /*
    05:43:36.846 [     main] 클라이언트 시작
    05:43:36.869 [     main] 소켓 연결: Socket[addr=localhost/127.0.0.1,port=12345,localport=50080]
    전송 문자: Hello
    05:43:46.884 [     main] client -> server: Hello
    05:43:46.885 [     main] client <- server: Hello World!
    전송 문자: exit
    05:44:10.408 [     main] client -> server: exit
    05:44:10.409 [     main] 연결 종료: Socket[addr=localhost/127.0.0.1,port=12345,localport=50080]
    */
}
