package cn.skcks.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/*
    IO 文件流
    标准步骤
 */
public class TestSteam_1 {
    public static void main(String[] args) throws IOException {

        // 创建源
        File dir = new File("io");

        if (!dir.exists()) {
            System.out.println(dir.mkdirs() ? "文件夹创建成功" : "");
        }

        File file = new File(dir, "TestSteam_1");
        System.out.println(file.createNewFile() ? "文件创建成功" : "文件已存在");


        // 自动资源管理 - 自动释放资源
        try (InputStream fileInput = new FileInputStream(file) ) {  // 输入流
            // 操作
            // 读取数据
            int tmp;
            while ((tmp = fileInput.read()) != -1) {
                System.out.print((char) tmp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 常规方法 手动资源管理
//        InputStream fileInput = null;
//        try {
//            fileInput = new FileInputStream(file);
//
//            // 操作
//            // 读取数据
//            int tmp;
//            while ((tmp = fileInput.read()) != -1) {
//                System.out.println((char) tmp);
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            // 释放资源
//            if(fileInput != null)
//            {
//                fileInput.close();
//            }
//        }


    }
}
