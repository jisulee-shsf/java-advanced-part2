package was.v2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static java.nio.charset.StandardCharsets.UTF_8;
import static util.MyLogger.log;

public class HttpRequestHandlerV2 implements Runnable {

    private final Socket socket;

    public HttpRequestHandlerV2(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            process();
        } catch (IOException e) {
            log(e);
        }
    }

    private void process() throws IOException {
        try (socket;
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), UTF_8));
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), false, UTF_8)) {

            String requestString = requestToString(bufferedReader);
            if (requestString.contains("/favicon.ico")) {
                log("favicon 요청");
                return;
            }
            log("HTTP 요청 정보 출력");
            System.out.println(requestString);

            log("HTTP 응답 생성 중...");
            sleep(5000);

            responseToClient(printWriter);
            log("HTTP 응답 전달 완료");
        }
    }

    private String requestToString(BufferedReader bufferedReader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.isEmpty()) {
                break;
            }
            stringBuilder.append(line).append("\n");
        }
        return stringBuilder.toString();
    }

    private void responseToClient(PrintWriter printWriter) {
        String body = "<h1>Hello World!</h1>";
        int length = body.getBytes(UTF_8).length;

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HTTP/1.1 200 OK\r\n");
        stringBuilder.append("Content-Type: text/html\r\n");
        stringBuilder.append("Content-Length: ").append(length).append("\r\n");
        stringBuilder.append("\r\n");
        stringBuilder.append(body);

        log("HTTP 응답 정보 출력");
        System.out.println(stringBuilder);

        printWriter.println(stringBuilder);
        printWriter.flush();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
