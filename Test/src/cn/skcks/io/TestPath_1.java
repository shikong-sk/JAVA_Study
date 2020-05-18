package cn.skcks.io;

import java.io.File;

public class TestPath_1 {
    public static void main(String[] args) {
        String path = "E:\\#Java\\Test\\images\\logo.png";

        System.out.println(File.separatorChar);
        System.out.println("E:" + File.separatorChar + "#Java" + File.separatorChar + "Test" + File.separatorChar +
                "images" + File.separatorChar + "logo.png");
        System.out.println(path);
    }
}
