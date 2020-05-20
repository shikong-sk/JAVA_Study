package cn.skcks.io;

import java.io.*;

/*
    输入流 + 输出流 + 字符缓冲流
    缓冲流 提升效率
    逐行读取、写入
    实现 文本文件拷贝
 */
public class TestBufferedCopyText {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // 源文件
        File src = new File("io/TestBufferedStream_3");

        // 目标文件
        File dest = new File("io/TestBufferedStream_3_copy");

        // 手动资源管理

        try (
                BufferedReader srcStream = new BufferedReader(new FileReader(src));
                BufferedWriter destStream = new BufferedWriter(new FileWriter(dest))
        ) {

            System.out.println("源文件：" + src.getAbsolutePath());
            System.out.println("目标文件：" + dest.getAbsolutePath());
            System.out.println("=====  执行复制文件  =====");

            String line;
            // 逐行读取、写入
            while ((line = srcStream.readLine()) != null) {
                destStream.write(line);
                destStream.newLine();
            }

            // 刷新文件缓存
            destStream.flush();

            System.out.println("=====  文件复制成功  =====");
            long endTime = System.currentTimeMillis();
            System.out.println("耗时：" + (endTime - startTime) + "ms");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
