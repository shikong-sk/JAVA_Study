package cn.skcks.thread;

import java.util.concurrent.*;

/*
    Thread 多线程

    java.util.concurrent
    JUC 并发 框架

    通过实现 Callable 接口 实现

    需要借助服务 和 线程池 运行
    可 throw 抛出异常
    避免单继承的局限性,优先使用接口
    方便共享资源
    实现并发

    call() 方法 线程入口
    调用 ExecutorService 服务类
    Executors.newFixedThreadPool(线程池).submit(线程类) 方法 启动线程
    返回 Future<返回值类型> 对象
    可使用 .get() 方法获取 Future 中的值
    执行完需使用 .shutdownNow() 方法关闭线程
 */
public class CallableDownload implements Callable<Boolean> {

    private final String url;
    private final String path;

    public CallableDownload(String url,String path)
    {
        this.url = url;
        this.path = path;
    }

    @Override
    // 线程入口
    public Boolean call() {
        TestDownload threadDownload = new TestDownload();
        threadDownload.download(url,path);
        System.out.println(path);
        return true;
    }

    public static void main(String[] args) {
        // 创建线程类
        CallableDownload threadDownload1 = new CallableDownload(
                "https://i0.hdslb.com/bfs/archive/f2649dfa6af9cec8976f0237c4772eb60cdcfd5f.png",
                "download/bilibili.png"
        );

        CallableDownload threadDownload2 = new CallableDownload(
                "https://www.baidu.com/img/flexible/logo/pc/result.png",
                "download/baidu.png"
        );

        CallableDownload threadDownload3 = new CallableDownload(
                "https://www.dogedoge.com/assets/new_logo_mobile.min.png",
                "download/dogedoge.png"
        );

        // 创建服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // 提交执行
        Future<Boolean> res1 = executorService.submit(threadDownload1);
        Future<Boolean> res2 = executorService.submit(threadDownload2);
        Future<Boolean> res3 = executorService.submit(threadDownload3);
        // 获取结果
        try {
            boolean b1 = res1.get();
            boolean b2 = res2.get();
            boolean b3 = res3.get();

            System.out.println(b1 + " " + b2 + " " + b3);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        // 关闭服务
        executorService.shutdownNow();

    }
}
