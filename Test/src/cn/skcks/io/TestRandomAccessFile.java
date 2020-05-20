package cn.skcks.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
    文件随机读写
    RandomAccessFile
 */
public class TestRandomAccessFile {
    public static void main(String[] args) {

        test1();

        test2();

        test3();
    }

    public static void readByte(RandomAccessFile randomAccessFile) throws IOException {
        readByte(randomAccessFile, 1024);
    }

    public static void readByte(RandomAccessFile randomAccessFile, int len) throws IOException {
        byte[] flush = new byte[len];
        while ((len = randomAccessFile.read(flush)) != -1) {
            System.out.print(new String(flush, 0, len));
        }
        System.out.println();
    }

    // 分块读取
    public static void readByte(RandomAccessFile randomAccessFile, int len, long beginPos, int size) throws IOException {
        randomAccessFile.seek(beginPos);

        byte[] flush = new byte[len];
        while ((len = randomAccessFile.read(flush)) != -1) {
            if (size > len) {
                System.out.print(new String(flush, 0, len));
                size -= len;
            } else {
                System.out.print(new String(flush, 0, size));
                break;
            }
        }
//        System.out.println();
    }

    // 按块 分段读取
    public static void readByte(RandomAccessFile randomAccessFile, int len, long beginPos) throws IOException {

        long fileLen = randomAccessFile.length();

        int block = (int) Math.ceil(fileLen / (double) len);

        int size;

        System.out.println(fileLen);

        for (int i = 0; i < block; i++) {

            if (beginPos > i * len) {
                size = len;
                fileLen -= size;    // 剩余量
                continue;
            }

            beginPos = i * len;
            if (i == block - 1) {
                size = (int) fileLen;
            } else {
                size = len;
                fileLen -= size;    // 剩余量
            }

//            System.out.println(i + " " + beginPos + " " + size + " ");
            readByte(randomAccessFile, len, beginPos, size);
        }

//        randomAccessFile.seek(beginPos);

//        byte[] flush = new byte[len];
//        while ((len = randomAccessFile.read(flush)) != -1) {
//            if(size > len)
//            {
//                System.out.print(new String(flush, 0, len));
//                size -= len;
//            }
//            else{
//                System.out.print(new String(flush, 0, size));
//                break;
//            }
//        }
//        System.out.println();
    }

    public static void test1() {
        // 手动资源管理
//        try {
//            RandomAccessFile randomAccessFile = new RandomAccessFile(new File("images/logo.png"), "r");
//
//            // ...
//
//            randomAccessFile.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // 自动资源管理
        try (
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File("io/TestStream_copy"), "r")
        ) {

            // 指定起始位置 读取文件剩余的所有内容
            randomAccessFile.seek(0);
            readByte(randomAccessFile, 2);

            randomAccessFile.seek(2);
            readByte(randomAccessFile, 2);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        try (
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File("io/TestStream_copy"), "r")
        ) {

            // 每次读取 len 个字符
            // 指定起始位置 beginPos
            // 读取文件 size 个字节
            readByte(randomAccessFile, 2, 2, 4);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test3() {
        try (
                RandomAccessFile randomAccessFile = new RandomAccessFile(new File("io/TestStream_copy"), "r")
        ) {

            // 每次读取 len 个字符
            // 指定起始位置 beginPos
            // 每一块的大小 为 (文件大小/len)
            // 若起始位置 > 分割块所在起始位置 则从下一个块开始读取

            readByte(randomAccessFile, 2, 1);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
