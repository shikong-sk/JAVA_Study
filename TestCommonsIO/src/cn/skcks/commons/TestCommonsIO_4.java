package cn.skcks.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/*
    CommonsIO 库
    写出文件
 */
public class TestCommonsIO_4 {
    public static void main(String[] args) {
        try {

            // 文件写出
            FileUtils.write(new File("io/Test"),"12345 Abc\r\n",StandardCharsets.UTF_8,false);
            FileUtils.writeStringToFile(new File("io/Test"),"时空旅行者\r\n",StandardCharsets.UTF_8,true);
            FileUtils.writeByteArrayToFile(new File("io/Test"),"文件读写".getBytes(StandardCharsets.UTF_8),true);

            // 逐行写出
            List<String> data = new ArrayList<>();
            data.add("111");
            data.add("222");
            data.add("333");

            FileUtils.writeLines(new File("io/Test2"),"UTF8",data,false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
