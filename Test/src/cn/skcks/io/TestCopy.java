package cn.skcks.io;

import java.io.*;

/*
    输入流 + 输出流
    实现 文件拷贝
 */
public class TestCopy {
    public static void main(String[] args) {
        // 源文件
        File src = new File("io/TestSteam_1");

        // 目标文件
        File dest = new File("io/TestSteam_copy");

        // 自动资源管理
//        try (
//                FileInputStream srcStream = new FileInputStream(src);
//                FileOutputStream destStream = new FileOutputStream(dest);
//        ) {
//            byte[] flush = new byte[1024 / 2];
//            int readLen;
//            while ((readLen = srcStream.read(flush)) != -1) {
//                destStream.write(flush, 0, readLen);
//            }
//            destStream.flush();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 手动资源管理
        FileInputStream srcStream = null;
        FileOutputStream destStream = null;
        try {
            // 输入文件流
            srcStream = new FileInputStream(src);

            // 输出文件流
            destStream = new FileOutputStream(dest);

            System.out.println("源文件：" + src.getAbsolutePath());
            System.out.println("目标文件：" + dest.getAbsolutePath());
            System.out.println("=====  执行复制文件  =====");

            byte[] flush = new byte[1024 / 2];
            long fileLength = src.length();
            int readLen;
            while ((readLen = srcStream.read(flush)) != -1) {
                destStream.write(flush, 0, readLen);
                System.out.println("=====    " + String.format("%3.2f",fileLength / (double)readLen * 100) + "%    =====");
            }

            // 刷新文件缓存
            destStream.flush();

            System.out.println("=====  文件复制成功  =====");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 分别关闭资源
            // 后打开的资源先关闭
            if (destStream != null) {
                try {
                    destStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (srcStream != null) {
                try {
                    srcStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
