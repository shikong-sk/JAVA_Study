package cn.skcks.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/*
    CommonsIO 库
    文件复制
 */
public class TestCommonsIO_5 {
    public static void main(String[] args) {
        try {

            // 文件复制
            FileUtils.copyFile(new File("io/Test2"),new File("io/Test2_Copy"));

            // 复制文件到目录
            FileUtils.copyFileToDirectory(new File("io/Test2_Copy"),new File("io/Copy"));

            // 复制目录
            FileUtils.copyDirectory(new File("io/Copy"),new File("io/CopyCopy"));

            // 复制目录到目录内
            FileUtils.copyDirectoryToDirectory(new File("io/Copy"),new File("io/CopyCopy"));

            // 复制 URL 内容
            String url = "https://www.baidu.com/img/baidu_jgylogo3.gif";
            FileUtils.copyURLToFile(new URL(url),new File("io/images/baidu.png"));

            // 获取 URL 文本内容
            String data = IOUtils.toString(new URL("http://www.baidu.com"),StandardCharsets.UTF_8);
            System.out.println(data);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
