package io.buffered;

import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.FILE_NAME;
import static io.buffered.BufferedConst.FILE_SIZE;

public class CreateFileV4 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);

        long startTime = System.currentTimeMillis();

        byte[] buffer = new byte[FILE_SIZE];
        for (int i = 0; i < FILE_SIZE; i++) {
            buffer[i] = 1;
        }
        fileOutputStream.write(buffer);
        fileOutputStream.close();

        long endTime = System.currentTimeMillis();

        System.out.println("file created = " + FILE_NAME);
        System.out.println("file size = " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("time taken = " + (endTime - startTime) + "ms");
        /*
        file created = temp/buffered.dat
        file size = 10MB
        time taken = 51ms
        */
    }
}
