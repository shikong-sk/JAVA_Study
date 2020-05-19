package cn.skcks.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
    IO 流
    输入流
    加入 字节输入缓冲流
 */
public class TestBufferedStream_1 {
    public static void main(String[] args) {

        // 创建源
        File dir = new File("io");

        if (!dir.exists()) {
            System.out.println(dir.mkdirs() ? "文件夹创建成功" : "");
        }

        File file = new File(dir, "TestBufferedStream_1");

        try {
            System.out.println(file.createNewFile() ? "文件创建成功" : "文件已存在");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 自动资源管理 - 自动释放资源
        try (
//                InputStream fileInput = new FileInputStream(file);
//                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInput)
                BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(file))
        ) {
            // 分段读取
            byte[] flush = new byte[1024 / 2]; // 缓冲区

            int tmp;
            while ((tmp = fileInput.read(flush)) != -1) {
                String string = new String(flush, 0, tmp);
                System.out.print(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
