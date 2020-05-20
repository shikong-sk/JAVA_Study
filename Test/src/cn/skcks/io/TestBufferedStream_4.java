package cn.skcks.io;

import java.io.*;

/*
    IO 文件流
    文件字符 输入、输出流
    加入 字符输入、输出缓冲流
    改进 逐行读取
 */
public class TestBufferedStream_4 {
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
        // 逐行写入
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file)) ) {

            System.out.println("=====  写入文件内容  =====");

            sTime = System.currentTimeMillis();

            fileWriter.write("时空旅行者");
            fileWriter.newLine();
            fileWriter.write("123 Abc");

            fileWriter.flush();

            eTime = System.currentTimeMillis();

            System.out.println( "耗时：" + (eTime-sTime) + "ms");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // 自动资源管理 - 自动释放资源
        // 字符输入流
        // 逐行读取
        try (BufferedReader fileReader = new BufferedReader(new FileReader(file)) ) {

            System.out.println("=====  读取文件内容  =====");

            sTime = System.currentTimeMillis();

            String line;
            while((line = fileReader.readLine()) != null)
            {
                System.out.println(line);
            }

            eTime = System.currentTimeMillis();

            System.out.println( "耗时：" + (eTime-sTime) + "ms");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
