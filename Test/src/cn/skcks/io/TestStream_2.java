package cn.skcks.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
    IO 文件流
    文件字节 输入流
 */
public class TestStream_2 {
    public static void main(String[] args) throws IOException {

        // 创建源
        File dir = new File("io");

        if (!dir.exists()) {
            System.out.println(dir.mkdirs() ? "文件夹创建成功" : "");
        }

        File file = new File(dir, "TestStream_1");
        System.out.println(file.createNewFile() ? "文件创建成功" : "文件已存在");


        // 自动资源管理 - 自动释放资源
        try (InputStream fileInput = new FileInputStream(file) ) {  // 输入流

            // 分段读取
            byte[] flush = new byte[1024 / 2]; // 缓冲区

            int tmp;
            while ((tmp = fileInput.read(flush)) != -1) {
                String string = new String(flush,0,tmp);
                System.out.print(string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
