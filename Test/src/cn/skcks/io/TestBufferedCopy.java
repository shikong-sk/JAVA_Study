package cn.skcks.io;

import java.io.*;

/*
    输入流 + 输出流 + 字节缓冲流
    缓冲流 提升效率
    实现 文件拷贝
 */
public class TestBufferedCopy {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // 源文件
        File src = new File("io/TestStream_1");
//        File src = new File("E:\\#编程语言速成\\learnxinyminutes-docs.zip");

        // 目标文件
        File dest = new File("io/TestStream_copy");

        // 手动资源管理

        try (
                BufferedInputStream srcStream = new BufferedInputStream(new FileInputStream(src));
                BufferedOutputStream destStream = new BufferedOutputStream(new FileOutputStream(dest))
        ) {

            System.out.println("源文件：" + src.getAbsolutePath());
            System.out.println("目标文件：" + dest.getAbsolutePath());
            System.out.println("=====  执行复制文件  =====");

            int bufferedLen = 1024 / 2;
            byte[] flush = new byte[bufferedLen];
            int readLen;
            while ((readLen = srcStream.read(flush)) != -1) {
                destStream.write(flush, 0, readLen);
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
