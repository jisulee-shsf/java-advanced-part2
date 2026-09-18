package io.start;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PrintStreamMain {

    public static void main(String[] args) throws IOException {
        byte[] bytes = "hello\n".getBytes(UTF_8);
        System.out.println(Arrays.toString(bytes)); // [104, 101, 108, 108, 111, 10]

        PrintStream printStream = System.out;
        printStream.write(bytes); // Hello!
        printStream.println("print"); // print
    }
}
