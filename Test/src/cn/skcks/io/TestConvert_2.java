package cn.skcks.io;

import java.io.*;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    转换流
    字节流转换为字符流
    InputStreamWriter InputStreamReader
    以字符集形式操作字节流
    可以指定字符集
    使用缓冲流提升效率

    转换并使用网络资源
 */
public class TestConvert_2 {
    public static void main(String[] args) {
        long sTime;
        long eTime;
        long[][] Times = new long[3][10];
        List<Long> Time = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            sTime = System.currentTimeMillis();
            test1();
            eTime = System.currentTimeMillis();
            Times[0][i] = eTime - sTime;
        }

        for (int i = 0; i < 10; i++) {
            sTime = System.currentTimeMillis();
            test2();
            eTime = System.currentTimeMillis();
            Times[1][i] = eTime - sTime;
        }

        for (int i = 0; i < 10; i++) {
            sTime = System.currentTimeMillis();
            test3();
            eTime = System.currentTimeMillis();
            Times[2][i] = eTime - sTime;
        }


        for (int i = 0; i < Times.length; i++) {
            long k = 0;
            for (int j = 0; j < Times[i].length; j++) {
                k += Times[i][j];
            }
            Time.add(i, k / Times[i].length);
        }

        for (Long aLong : Time) {
            System.out.println("耗时：" + aLong + "ms");
        }

        test4();

    }

    // 逐字节读取
    public static void test1() {
        try (
                BufferedInputStream inputStream = new BufferedInputStream(new URL("http://www.baidu.com").openStream())
        ) {

            int len;
            // 一次读取一个字节 字节数不足会导致乱码
            while ((len = inputStream.read()) != -1) {
                System.out.print((char) len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 分段读取
    public static void test2() {
        try (
                BufferedInputStream inputStream = new BufferedInputStream(new URL("http://www.baidu.com").openStream())
        ) {
            int len;
            byte[] flush = new byte[1024];
            while ((len = inputStream.read(flush)) != -1) {
                System.out.print(new String(flush, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 按行读取
    // 可指定文字编码 避免乱码问题
    public static void test3() {
        try (
                BufferedReader inputStream =
                        new BufferedReader(
                                new InputStreamReader(
                                        // 网络流
                                        new URL("http://www.baidu.com").openStream(),
                                        StandardCharsets.UTF_8
                                )
                        )
        ) {
            String line;
            while ((line = inputStream.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 存储网络数据
    // 需要统一字符集避免导致乱码
    public static void test4() {
        try (
                BufferedReader inputStream =
                        new BufferedReader(
                                new InputStreamReader(
                                        // 网络流
                                        new URL("http://www.baidu.com").openStream(),
                                        StandardCharsets.UTF_8
                                )
                        );
                BufferedWriter outputStream =
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        new FileOutputStream("io/baidu.html"),
                                        StandardCharsets.UTF_8
                                )
                        )
        ) {
            String line;
            while ((line = inputStream.readLine()) != null) {
//                outputStream.write(line);
                // 编码转换
                outputStream.write(new String(line.getBytes(StandardCharsets.UTF_8),0,line.length(),StandardCharsets.UTF_8));
                outputStream.newLine();
            }
            outputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
