package io.buffered;

import java.io.FileInputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.FILE_NAME;

public class ReadFileV4 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);

        long startTime = System.currentTimeMillis();

        byte[] bytes = fileInputStream.readAllBytes();
        fileInputStream.close();

        long endTime = System.currentTimeMillis();

        System.out.println("file created = " + FILE_NAME);
        System.out.println("file size = " + bytes.length / 1024 / 1024 + "MB");
        System.out.println("time taken = " + (endTime - startTime) + "ms");
        /*
        file created = temp/buffered.dat
        file size = 10MB
        time taken = 20ms
        */
    }
}
