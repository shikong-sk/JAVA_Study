package cn.skcks.thread;

/*
    Thread 多线程

    Runnable 多线程下载
 */
public class RunnableDownload implements Runnable {

    private final String url;

    private final String path;

    public RunnableDownload(String url, String path) {
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
        RunnableDownload threadDownload1 = new RunnableDownload(
                "https://i0.hdslb.com/bfs/archive/f2649dfa6af9cec8976f0237c4772eb60cdcfd5f.png",
                "download/bilibili.png"
        );

        RunnableDownload threadDownload2 = new RunnableDownload(
                "https://www.baidu.com/img/flexible/logo/pc/result.png",
                "download/baidu.png"
        );

        RunnableDownload threadDownload3 = new RunnableDownload(
                "https://www.dogedoge.com/assets/new_logo_mobile.min.png",
                "download/dogedoge.png"
        );

        // 启动线程
        new Thread(threadDownload1).start();
        new Thread(threadDownload2).start();
        new Thread(threadDownload3).start();

    }
}
