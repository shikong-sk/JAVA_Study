package cn.skcks.net.socket.udp;

import java.io.*;

public class FileUtils {

    // 将文件转为字节数组
    public static byte[] fileToByteArray(String path) {
        File file = new File(path);

        try (
                InputStream inputStream = new FileInputStream(file);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream()
        ) {
            // 缓冲区
            byte[] flush = new byte[1024];

            // 读取到的字节长度
            int len;

            while ((len = inputStream.read(flush)) != -1) {
                // 将读取的字节写入字节数组中
                outputStream.write(flush, 0, len);
            }

            // 刷新缓冲区
            outputStream.flush();

            // 返回字节数组
            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    // 将字节数组转为文件
    public static boolean byteArrayToFile(byte[] data, String path) {

        File file = new File(path);

        try (
                InputStream inputStream = new ByteArrayInputStream(data);
                OutputStream outputStream = new FileOutputStream(file)
        ) {

            byte[] flush = new byte[1024];
            int len;

            while ((len = inputStream.read(flush)) != -1) {
                outputStream.write(flush, 0, len);
            }

            // 刷新缓冲区
            outputStream.flush();

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
