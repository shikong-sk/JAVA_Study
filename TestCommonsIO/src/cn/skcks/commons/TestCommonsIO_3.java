package cn.skcks.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;

/*
    CommonsIO 库
    读取文件
 */
public class TestCommonsIO_3 {
    public static void main(String[] args) {
        try {
            // 读取文件所有字符
            String string = FileUtils.readFileToString(new File("io/Test"), StandardCharsets.UTF_8);
            System.out.println(string);

            System.out.println("=================================");

            // 读取至字节数组
            byte[] data = FileUtils.readFileToByteArray(new File("io/Test"));
            System.out.println(data.length);

            System.out.println("=================================");

            // 逐行读取
            List<String> stringList = FileUtils.readLines(new File("io/Test"),StandardCharsets.UTF_8);
            for (String tmp:stringList)
            {
                System.out.println(tmp);
            }

            System.out.println("=================================");

            // 迭代器
            LineIterator lineIterator = FileUtils.lineIterator(new File("io/Test"),"utf8");
            while (lineIterator.hasNext())
            {
                System.out.println(lineIterator.next());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
