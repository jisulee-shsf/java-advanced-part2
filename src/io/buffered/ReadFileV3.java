package io.buffered;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import static io.buffered.BufferedConst.BUFFER_SIZE;
import static io.buffered.BufferedConst.FILE_NAME;

public class ReadFileV3 {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, BUFFER_SIZE);

        long startTime = System.currentTimeMillis();

        int fileSize = 0;
        int data;
        while ((data = bufferedInputStream.read()) != -1) {
            fileSize++;
        }
        bufferedInputStream.close();

        long endTime = System.currentTimeMillis();

        System.out.println("file created = " + FILE_NAME);
        System.out.println("file size = " + fileSize / 1024 / 1024 + "MB");
        System.out.println("time taken = " + (endTime - startTime) + "ms");
        /*
        file created = temp/buffered.dat
        file size = 10MB
        time taken = 442ms
        */
    }
}
