package cn.skcks.io;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/*
    字符集
    编码、解码
 */
public class TestCharSet {
    public static void main(String[] args) {
        // UTF8 英文 1个字节 中文 3个字节
        String string = "123 Abc 时空";

        byte[] bytes;

        // 编码
        bytes = string.getBytes();  // 工程默认字符集
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));

        try {
            // GBK 英文 1个字节 中文 2个字节
            bytes = string.getBytes("GBK");  // GBK 编码
            System.out.println(bytes.length);
            System.out.println(Arrays.toString(bytes));

            // 解码

            string = new String(bytes,0,bytes.length,"GBK");
            System.out.println(string);


            // 字符集不正确导致乱码
            string = new String(bytes,0,bytes.length, StandardCharsets.UTF_8);
            System.out.println(string);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
