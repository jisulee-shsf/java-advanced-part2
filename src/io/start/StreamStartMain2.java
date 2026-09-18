package io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class StreamStartMain2 {

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("temp/hello.dat");
        byte[] input = {65, 66, 67, 68};
        fileOutputStream.write(input);
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("temp/hello.dat");
        byte[] bytes = new byte[10];
        int readCount = fileInputStream.read(bytes, 0, 10);
        System.out.println("readCount = " + readCount);
        System.out.println(Arrays.toString(bytes));
        fileInputStream.close();
        /*
        readCount = 4
        [65, 66, 67, 68, 0, 0, 0, 0, 0, 0]
        */
    }
}
