package cn.skcks.io;

import java.io.*;

/*
    打印流
    PrintStream
 */
public class TestPrintStream_1 {
    public static void main(String[] args) {
        PrintStream printStream = System.out;

        printStream.println("打印流");

        try {
//            printStream = new PrintStream(new BufferedOutputStream(new FileOutputStream("io/TestPrintStream")));

            // 自动刷新缓存
            printStream = new PrintStream(new BufferedOutputStream(new FileOutputStream("io/TestPrintStream")),true);
            printStream.println("打印流 输出到文件");

            // 输出重定向 至 文件
            System.setOut(printStream);
            System.out.println("输出重定向 至 文件");

            // 输出重定向 至 控制台
            System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));
            System.out.println("输出重定向 至 控制台");

            // 手动刷新缓存
//            printStream.flush();

            // 关闭输出流
            printStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
