package cn.skcks.io;

import java.io.File;
import java.util.Objects;

/*
    File 对象
    遍历文件夹 所有目录、文件
    统计文件夹大小
 */
public class TestDir_3 {
    public static void main(String[] args) {
        File file = new File("images");

        printFile(file);

        System.out.println("========================================");

        // 封装方法类
        System.out.println(new TestGetLength(file));
        System.out.println(new TestGetLength(new File(file,"logo.png")));
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

        System.out.print("\t" + getSize(getLength(file)));

        for (int i = 0; i <= deep; i++) {
            System.out.print("\t");
        }
        System.out.println(file.getName());
    }

    public static long getLength(File file){
        if (file.isFile())
        {
            return file.length();
        }
        else if(file.isDirectory()){

            long length = 0;
            for (File dir: Objects.requireNonNull(file.listFiles()))
            {
                length += getLength(dir);
            }
            return length;
        }

        return 0;
    }

    public static String getSize(long size){
        String[] unit = {"B","K","M","G","T"};
        int i;

        for (i=0;i<unit.length;i++)
        {
            if(size >= 1024)
            {
                size /= 1024;
            }
            else{
                break;
            }
        }

        return size + " " + unit[i];

    }
}
