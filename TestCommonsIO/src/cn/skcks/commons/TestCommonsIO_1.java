package cn.skcks.commons;

import org.apache.commons.io.FileUtils;

import java.io.File;

/*
    CommonsIO 库
    获取文件、文件夹大小
 */
public class TestCommonsIO_1 {
    public static void main(String[] args) {
        // 文件大小
        long len = FileUtils.sizeOf(new File("lib/commons-io-2.6.jar"));
        System.out.println(len);

        // 目录大小
        len = FileUtils.sizeOf(new File("lib"));
        System.out.println(len);
    }
}
