package cn.skcks.io;

import java.io.File;
import java.util.Arrays;

/*
    File 对象
    文件夹 创建、遍历
 */
public class TestDir_1 {
    public static void main(String[] args) {
        File dir = new File("images/temp");
        File dirs = new File(dir,"dirs");

        // 文件夹 创建
        System.out.println(dir.mkdir());
        System.out.println(dirs.mkdirs());

        System.out.println("========================================");

        // 批量创建文件
        for(int i=0;i<5;i++){
            try {
                System.out.println("创建文件 tmpFile_" + i + "：" + new File(dirs,"tmpFile_" + i).createNewFile());
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        System.out.println("========================================");

        // 列出下级名称
        System.out.println(Arrays.deepToString(dirs.list()));

        System.out.println("========================================");

        // 列出下级对象
        System.out.println(Arrays.deepToString(dirs.listFiles()));

        System.out.println("========================================");

        // 列出所有盘符
        System.out.println(Arrays.toString(File.listRoots()));

        System.out.println("========================================");

        System.out.println(dirs.delete());
        System.out.println(dir.delete());
    }
}
