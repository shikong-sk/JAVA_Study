package cn.skcks.io;

import java.io.File;

/*
    File对象
 */
public class TestFile_1 {
    public static void main(String[] args) {
        String path = "E:\\#Java\\Test\\images\\logo.png";

        File src = new File(path);

        System.out.println(src.length() + " Bytes");
        System.out.println(String.format("%.2f",src.length()/ 1024d) + " Kb");


    }
}
