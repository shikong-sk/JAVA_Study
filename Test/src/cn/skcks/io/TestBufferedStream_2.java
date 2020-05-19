package cn.skcks.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
    IO 流
    输出流
    加入 字节输出缓冲流
 */
public class TestBufferedStream_2 {
    public static void main(String[] args) {

        // 创建源
        File dir = new File("io");

        if (!dir.exists()) {
            System.out.println(dir.mkdirs() ? "文件夹创建成功" : "");
        }

        File file = new File(dir, "TestBufferedStream_1");

        try (
//                OutputStream fileOutput = new FileOutputStream(file,true)
                BufferedOutputStream fileOutput = new BufferedOutputStream(new FileOutputStream(file,false))
        ) {
            String string = "123 Abc 时空旅行者";

            // 指定字节编码
            byte[] bytes = string.getBytes(StandardCharsets.UTF_8);

            // 写入文件
            fileOutput.write(bytes,0,bytes.length);

            // 刷新文件缓存
            fileOutput.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
