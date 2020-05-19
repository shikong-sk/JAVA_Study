package cn.skcks.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/*
    字节数组流
 */
public class TestByteArraySteam_1 {
    public static void main(String[] args) {

        // 数据源
//        byte[] src = "123 Abc".getBytes();

        // 字节数组输出流
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()){

            String string = "123 Abc";

            byte[] data = string.getBytes();

            outputStream.write(data);
            outputStream.flush();

            // 输出数据内容
            System.out.println(new String(outputStream.toByteArray(),0,outputStream.size()));
            // 字节数据
            System.out.println(Arrays.toString(outputStream.toByteArray()));

            // 字节数组输入流
            try (InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray())){

                byte[] flush = new byte[1024 / 2];
                int len;
                while ((len = inputStream.read(flush)) != -1)
                {
                    // 读取字节数组内容
                    System.out.println(new String(flush,0,len));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


//        try (InputStream inputStream = new ByteArrayInputStream(src)){
//
//            byte[] flush = new byte[1024 / 2];
//            int len;
//            while ((len = inputStream.read(flush)) != -1)
//            {
//                System.out.println(new String(flush,0,len));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
