package cn.skcks.io;

import java.io.*;

/*
    IO 文件流
    文件字符 输入、输出流
    加入 字符输入、输出缓冲流
 */
public class TestBufferedStream_3 {
    public static void main(String[] args) throws IOException {

        long sTime;
        long eTime;

        // 创建源
        File dir = new File("io");

        if (!dir.exists()) {
            System.out.println(dir.mkdirs() ? "文件夹创建成功" : "");
        }

        File file = new File(dir, "TestBufferedStream_3");

        // 自动资源管理 - 自动释放资源
        // 字符输出流
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file)) ) {

            System.out.println("=====  写入文件内容  =====");

            sTime = System.currentTimeMillis();

            String str = "时空旅行者\r\n123 Abc";

            System.out.println(str);

//            fileWriter.write(str);
            fileWriter.write(str,0,str.length());

            fileWriter.flush();

            eTime = System.currentTimeMillis();

            System.out.println( "耗时：" + (eTime-sTime) + "ms");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 自动资源管理 - 自动释放资源
        // 字符输入流
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file)) ) {

            System.out.println("=====  读取文件内容  =====");

            sTime = System.currentTimeMillis();

            char[] flush = new char[1024 / 2];
            int len;
            while((len = fileReader.read(flush)) != -1)
            {
                String str = new String(flush,0,len);

                System.out.println(str);
            }

            eTime = System.currentTimeMillis();

            System.out.println( "耗时：" + (eTime-sTime) + "ms");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
