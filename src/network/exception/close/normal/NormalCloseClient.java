package network.exception.close.normal;

import java.io.*;
import java.net.Socket;

import static util.MyLogger.log;

public class NormalCloseClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);
        log("소캣 연결: " + socket);
        InputStream inputStream = socket.getInputStream();

        readByInputStream(socket, inputStream);
        readByBufferedReader(socket, inputStream);
        readByDataInputStream(socket, inputStream);

        log("연결 종료: " + socket.isClosed());
    }

    private static void readByInputStream(Socket socket, InputStream inputStream) throws IOException {
        int read = inputStream.read();
        log("read: " + read);

        if (read == -1) {
            inputStream.close();
            socket.close();
        }
    }

    private static void readByBufferedReader(Socket socket, InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String readString = bufferedReader.readLine();
        log("readString: " + readString);

        if (readString == null) {
            bufferedReader.close();
            socket.close();
        }
    }

    private static void readByDataInputStream(Socket socket, InputStream inputStream) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        try {
            dataInputStream.readUTF();
        } catch (EOFException e) {
            log(e);
        } finally {
            dataInputStream.close();
            socket.close();
        }
    }
    /*
    08:03:59.447 [     main] 소캣 연결: Socket[addr=localhost/127.0.0.1,port=12345,localport=50387]
    08:04:00.472 [     main] read: -1
    08:04:00.474 [     main] readString: null
    08:04:00.474 [     main] java.io.EOFException
    08:04:00.475 [     main] 연결 종료: true
    */
}
