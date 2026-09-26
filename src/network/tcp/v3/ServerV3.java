package network.tcp.v3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class ServerV3 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            log("소켓 연결: " + socket);

            SessionV3 session = new SessionV3(socket);
            Thread thread = new Thread(session);
            thread.start();
        }
    }
    /*
    05:43:28.056 [     main] 서버 시작
    05:43:28.064 [     main] 서버 소켓 시작 - 리스닝 포트: 12345
    05:43:33.298 [     main] 소켓 연결: Socket[addr=/127.0.0.1,port=50076,localport=12345]
    05:43:36.867 [     main] 소켓 연결: Socket[addr=/127.0.0.1,port=50080,localport=12345]
    05:43:43.518 [ Thread-0] client -> server: Hello
    05:43:43.520 [ Thread-0] client <- server: Hello World!
    05:43:46.884 [ Thread-1] client -> server: Hello
    05:43:46.885 [ Thread-1] client <- server: Hello World!
    05:44:03.805 [ Thread-0] client -> server: exit
    05:44:03.805 [ Thread-0] 연결 종료: Socket[addr=/127.0.0.1,port=50076,localport=12345]
    05:44:10.408 [ Thread-1] client -> server: exit
    05:44:10.409 [ Thread-1] 연결 종료: Socket[addr=/127.0.0.1,port=50080,localport=12345]
    */
}
