package io.text;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV3 {

    public static void main(String[] args) throws IOException {
        String writeString = "ABC";
        System.out.println(writeString); // ABC

        // 파일 쓰기
        FileWriter fileWriter = new FileWriter(FILE_NAME, UTF_8);
        fileWriter.write(writeString);
        fileWriter.close();

        // 파일 읽기
        FileReader fileReader = new FileReader(FILE_NAME, UTF_8);

        StringBuilder content = new StringBuilder();
        int ch;
        while ((ch = fileReader.read()) != -1) {
            content.append((char) ch);
        }
        fileReader.close();
        System.out.println(content); // ABC
    }
}
