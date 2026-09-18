package io.text;

import java.io.*;

import static io.text.TextConst.FILE_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ReaderWriterMainV4 {

    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args) throws IOException {
        String writeString = "ABC\n가나다";
        System.out.println(writeString);
        /*
        ABC
        가나다
        */

        // 파일 쓰기
        FileWriter fileWriter = new FileWriter(FILE_NAME, UTF_8);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter, BUFFER_SIZE);
        bufferedWriter.write(writeString);
        bufferedWriter.close();

        // 파일 읽기
        FileReader fileReader = new FileReader(FILE_NAME, UTF_8);
        BufferedReader bufferedReader = new BufferedReader(fileReader, BUFFER_SIZE);

        StringBuilder content = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            content.append(line).append("\n");
        }
        bufferedReader.close();
        System.out.println(content);
        /*
        ABC
        가나다
        */
    }
}
