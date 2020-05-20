package cn.skcks.io;

import java.io.*;

/*
    打印流
    PrintWriter
    输出 至 文件
 */
public class TestPrintStream_2 {
    public static void main(String[] args) {

        try {
//            printStream = new PrintStream(new BufferedOutputStream(new FileOutputStream("io/TestPrintStream")));

            // 自动刷新缓存
            PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream("io/TestPrintWriter")),true);
            printWriter.println("打印流 输出到文件 PrintWriter");

            // 手动刷新缓存
//            printWriter.flush();

            // 关闭输出流
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
