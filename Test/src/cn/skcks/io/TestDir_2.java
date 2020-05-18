package cn.skcks.io;

import java.io.File;
import java.util.Arrays;
import java.util.Objects;

/*
    File 对象
    遍历文件夹 所有目录、文件
 */
public class TestDir_2 {
    public static void main(String[] args) {
        File file = new File("images");

        printFile(file);
    }

    public static void printFile(File file) {
        printFile(file, 0);
    }

    private static void printFile(File file, int deep) {
        if (file == null || !file.exists()) {
            return;
        } else if (file.isDirectory()) {
            for (File dir : Objects.requireNonNull(file.listFiles())) {
                printFile(dir, deep + 1);
            }
        }

        if (file.isFile())
        {
            System.out.print("文  件");
        }
        else if (file.isDirectory())
        {
            System.out.print("文件夹");
        }
        else{
            System.out.print("未  知");
        }

        for (int i = 0; i <= deep; i++) {
            System.out.print("\t");
        }
        System.out.println(file.getName());
    }
}
