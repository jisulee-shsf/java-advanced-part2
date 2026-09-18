package io.streams;

import java.io.*;

public class DataStreamEtcMain {

    public static void main(String[] args) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("temp/data.dat");
        DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);

        dataOutputStream.writeUTF("회원1");
        dataOutputStream.writeInt(10);
        dataOutputStream.writeDouble(10.5);
        dataOutputStream.writeBoolean(true);
        dataOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("temp/data.dat");
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);

        System.out.println(dataInputStream.readUTF());
        System.out.println(dataInputStream.readInt());
        System.out.println(dataInputStream.readDouble());
        System.out.println(dataInputStream.readBoolean());
        dataInputStream.close();
        /*
        회원1
        10
        10.5
        true
        */
    }
}
