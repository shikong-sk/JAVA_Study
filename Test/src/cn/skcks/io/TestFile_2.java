package cn.skcks.io;

import java.io.File;
import java.io.IOException;

/*
    File对象

    名称 或 路径
 */
public class TestFile_2 {
    public static void main(String[] args) {
        File file = new File("images/logo.png");

        // 基本信息
        System.out.println(file.getName());         // 文件名
        System.out.println(file.getPath());         // 相对 或 绝对路径
        System.out.println(file.getAbsolutePath()); // 绝对路径
        System.out.println(file.getParent());       // 父级路径

        File parent = file.getParentFile();         // 父级 File 对象
        System.out.println(parent.getName());

        System.out.println("========================================");

        // 文件状态
        System.out.println("文件是否存在：" + file.exists());             // 文件是否存在
        System.out.println("是否为文件："+ file.isFile());                // 是否为文件
        System.out.println("是否为文件夹：" + file.isDirectory());        // 是否为文件夹

        System.out.println("========================================");

        // 其他信息
        System.out.println(file.length());          // 文件大小 单位：Bytes
        System.out.println(parent.length());

        System.out.println("========================================");

        File newFile = new File(parent,"newFile");

        try {
            System.out.println("创建文件 newFile：" + newFile.createNewFile());

            System.out.println("删除文件 newFile：" + newFile.delete());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
