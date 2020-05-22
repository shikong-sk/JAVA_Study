package cn.skcks.thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/*
    Thread 多线程

    Thread 多线程下载
 */
public class ThreadDownload extends Thread {

    private final String url;

    private final String path;

    public ThreadDownload(String url, String path) {
        this.url = url;
        this.path = path;
    }

    @Override
    // 线程入口
    public void run() {
        TestDownload threadDownload = new TestDownload();
        threadDownload.download(url,path);
        System.out.println(path);
    }

    public static void main(String[] args) {
        // 创建线程类
        ThreadDownload threadDownload1 = new ThreadDownload(
                "https://i0.hdslb.com/bfs/archive/f2649dfa6af9cec8976f0237c4772eb60cdcfd5f.png",
                "download/bilibili.png"
        );

        ThreadDownload threadDownload2 = new ThreadDownload(
                "https://www.baidu.com/img/flexible/logo/pc/result.png",
                "download/baidu.png"
        );

        ThreadDownload threadDownload3 = new ThreadDownload(
                "https://www.dogedoge.com/assets/new_logo_mobile.min.png",
                "download/dogedoge.png"
        );

        // 启动线程
        threadDownload1.start();
        threadDownload2.start();
        threadDownload3.start();

    }
}
