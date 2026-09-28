package chat.client;

import java.io.DataInputStream;
import java.io.IOException;

import static util.MyLogger.log;

public class ReadHandler implements Runnable {

    private final DataInputStream inputStream;
    private final Client client;
    private boolean closed = false;

    public ReadHandler(DataInputStream inputStream, Client client) {
        this.inputStream = inputStream;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            String received = inputStream.readUTF();
            System.out.println(received);
        } catch (IOException e) {
            log(e);
        } finally {
            client.close();
        }
    }

    public synchronized void close() {
        if (closed) {
            return;
        }

        closed = true;
        log("readHandler 종료");
    }
}
