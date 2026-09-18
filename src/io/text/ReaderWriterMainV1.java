package io.text;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV1 {

    public static void main(String[] args) throws IOException {
        String writeString = "ABC";

        // String -> byte UTF_8 인코딩
        byte[] writeBytes = writeString.getBytes(UTF_8);
        System.out.println(writeString); // ABC
        System.out.println(Arrays.toString(writeBytes)); // [65, 66, 67]

        // 파일 쓰기
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        fileOutputStream.write(writeBytes);
        fileOutputStream.close();

        // 파일 읽기
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        byte[] readBytes = fileInputStream.readAllBytes();
        fileInputStream.close();

        // byte -> String UTF_8 디코딩
        String readString = new String(readBytes, UTF_8);
        System.out.println(Arrays.toString(readBytes)); // [65, 66, 67]
        System.out.println(readString); // ABC
    }
}
