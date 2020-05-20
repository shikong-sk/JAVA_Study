package cn.skcks.io;

import java.io.*;

/*
    数据流

    写出后读取
    读取顺序 与 写出顺序 必须一致
 */
public class TestDataStream {
    public static void main(String[] args) {

        // 写出
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

//        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(byteArrayOutputStream));

        try {
            dataOutputStream.writeUTF("123 abc 时空");
            dataOutputStream.writeInt(123456);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //
        byte[] data = byteArrayOutputStream.toByteArray();

        // 读取
//        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(data));
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(data)));

        try {
            String data1 = dataInputStream.readUTF();

            int data2 = dataInputStream.readInt();

            boolean data3 = dataInputStream.readBoolean();

            System.out.println(data1 + " " + data2 + " " + data3);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
