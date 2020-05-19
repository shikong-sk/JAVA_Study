package cn.skcks.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
    IO 文件流
    文件字符 输入、输出流
 */
public class TestStream_4 {
    public static void main(String[] args) throws IOException {

        // 创建源
        File dir = new File("io");

        if (!dir.exists()) {
            System.out.println(dir.mkdirs() ? "文件夹创建成功" : "");
        }

        File file = new File(dir, "TestStream_4");

        // 自动资源管理 - 自动释放资源
        // 字符输出流
        try (FileWriter fileWriter = new FileWriter(file) ) {

            System.out.println("=====  写入文件内容  =====");

            String str = "时空旅行者\r\n123 Abc";

            System.out.println(str);

//            fileWriter.write(str);
            fileWriter.write(str,0,str.length());

            fileWriter.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 自动资源管理 - 自动释放资源
        // 字符输入流
        try (FileReader fileReader = new FileReader(file) ) {

            System.out.println("=====  读取文件内容  =====");

            char[] flush = new char[1024 / 2];
            int len;
            while((len = fileReader.read(flush)) != -1)
            {
                String str = new String(flush,0,len);

                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
