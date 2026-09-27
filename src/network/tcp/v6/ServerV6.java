package network.tcp.v6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static util.MyLogger.log;

public class ServerV6 {

    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        log("서버 시작");
        SessionManagerV6 sessionManager = new SessionManagerV6();
        ServerSocket serverSocket = new ServerSocket(PORT);
        log("서버 소켓 시작 - 리스닝 포트: " + PORT);

        ShutdownHook shutdownHook = new ShutdownHook(sessionManager, serverSocket);
        Runtime.getRuntime().addShutdownHook(new Thread(shutdownHook, "shutdownHook"));

        try {
            while (true) {
                Socket socket = serverSocket.accept();
                log("소켓 연결: " + socket);

                SessionV6 session = new SessionV6(socket, sessionManager);
                Thread thread = new Thread(session);
                thread.start();
            }
        } catch (IOException e) {
            log("서버 소켓 종료: " + e);
        }
    }

    private static class ShutdownHook implements Runnable {
        private final SessionManagerV6 sessionManager;
        private final ServerSocket serverSocket;

        public ShutdownHook(SessionManagerV6 sessionManager, ServerSocket serverSocket) {
            this.sessionManager = sessionManager;
            this.serverSocket = serverSocket;
        }

        @Override
        public void run() {
            log("shutdownHook 실행");
            try {
                sessionManager.closeAll();
                serverSocket.close();

                Thread.sleep(1000);
            } catch (Exception e) {
                e.getStackTrace();
                System.out.println("e = " + e);
            }
        }
    }
}
