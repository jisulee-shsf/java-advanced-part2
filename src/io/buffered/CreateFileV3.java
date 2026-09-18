package io.buffered;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.*;

public class CreateFileV3 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, BUFFER_SIZE);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < FILE_SIZE; i++) {
            bufferedOutputStream.write(1);
        }
        bufferedOutputStream.close();

        long endTime = System.currentTimeMillis();

        System.out.println("file created = " + FILE_NAME);
        System.out.println("file size = " + FILE_SIZE / 1024 / 1024 + "MB");
        System.out.println("time taken = " + (endTime - startTime) + "ms");
        /*
        file created = temp/buffered.dat
        file size = 10MB
        time taken = 407ms
        */
    }
}
