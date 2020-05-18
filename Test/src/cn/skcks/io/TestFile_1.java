package cn.skcks.io;

import java.io.File;

/*
    File对象

    File 对象的构建
 */
public class TestFile_1 {
    public static void main(String[] args) {
        String path = "E:\\#Java\\Test\\images\\logo.png";

        File src1 = new File(path);

        System.out.println(src1.length() + " Bytes");
        System.out.println(String.format("%.2f",src1.length()/ 1024d) + " Kb");

        System.out.println("===========================================");

        File src2 = new File("E:/#Java/Test/images","logo.png");

        System.out.println(src2.length() + " Bytes");
        System.out.println(String.format("%.2f",src2.length()/ 1024d) + " Kb");

        System.out.println("===========================================");

        File src3 = new File(new File("E:/#Java/Test/images"),"logo.png");

        System.out.println(src3.length() + " Bytes");
        System.out.println(String.format("%.2f",src3.length()/ 1024d) + " Kb");

        System.out.println(src3.getAbsolutePath());
        System.out.println(new File("images/logo.png").getAbsolutePath());
        System.out.println(System.getProperty("user.dir"));
    }
}
