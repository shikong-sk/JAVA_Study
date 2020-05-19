package cn.skcks.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
    IO 文件流
    文件字节 输出流
 */
public class TestStream_3 {
    public static void main(String[] args) throws IOException {

        // 创建源
        File dir = new File("io");

        if (!dir.exists()) {
            System.out.println(dir.mkdirs() ? "文件夹创建成功" : "");
        }

        File file = new File(dir, "TestStream_3");

        // 自动资源管理 - 自动释放资源
        // 输出流
        // append 参数 是否追加至文件结尾
        try (OutputStream fileOutput = new FileOutputStream(file,true) ) {
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
