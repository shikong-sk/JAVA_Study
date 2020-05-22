package cn.skcks.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/*
    文件下载类
 */
public class TestDownload {
    public void download(String url,String path) {
        try {
            FileUtils.copyURLToFile(
                    new URL(url),
                    new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
