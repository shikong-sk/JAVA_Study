package cn.skcks.singleton;

import java.util.concurrent.CountDownLatch;

/*
	测试多线程下 5种 单例模式 的效率
 */
public class Test3 {
	public static void main(String[] args) {

		/*
			饿汉式
		 */
		long startTime = System.currentTimeMillis();

		int thread = 10;
		long executeNum  = 1000000L;
		final CountDownLatch countDownLatch = new CountDownLatch(thread);

		for (int i = 0; i < thread; i++) {
			new Thread(()->{
				for (int j = 0; j < executeNum; j++) {
					Object o = TestSingleton.getInstance();
				}
				countDownLatch.countDown();
			}).start();
		}

		try {
			// 阻塞 main 线程 直到所有子线程执行完毕
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long endTime = System.currentTimeMillis();

		System.out.println("饿汉式 执行 "+ executeNum +" 次 总耗时：" + (endTime - startTime) + " ms");


		/*
			懒汉式
		 */

		startTime = System.currentTimeMillis();

		final CountDownLatch countDownLatch2 = new CountDownLatch(thread);

		for (int i = 0; i < thread; i++) {
			new Thread(()->{
				for (int j = 0; j < executeNum; j++) {
					Object o = TestSingleton_2.getInstance();
				}
				countDownLatch2.countDown();
			}).start();
		}

		try {
			// 阻塞 main 线程 直到所有子线程执行完毕
			countDownLatch2.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		endTime = System.currentTimeMillis();

		System.out.println("懒汉式 执行 "+ executeNum +" 次 总耗时：" + (endTime - startTime) + " ms");

		/*
			双重检测锁式
		 */
		startTime = System.currentTimeMillis();

		final CountDownLatch countDownLatch3 = new CountDownLatch(thread);

		for (int i = 0; i < thread; i++) {
			new Thread(()->{
				for (int j = 0; j < executeNum; j++) {
					Object o = TestSingleton_3.getInstance();
				}
				countDownLatch3.countDown();
			}).start();
		}

		try {
			// 阻塞 main 线程 直到所有子线程执行完毕
			countDownLatch3.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		endTime = System.currentTimeMillis();

		System.out.println("双重检测锁式 执行 "+ executeNum +" 次 总耗时：" + (endTime - startTime) + " ms");

		/*
			静态内部类式
		 */
		startTime = System.currentTimeMillis();

		final CountDownLatch countDownLatch4 = new CountDownLatch(thread);

		for (int i = 0; i < thread; i++) {
			new Thread(()->{
				for (int j = 0; j < executeNum; j++) {
					Object o = TestSingleton_4.getInstance();
				}
				countDownLatch4.countDown();
			}).start();
		}

		try {
			// 阻塞 main 线程 直到所有子线程执行完毕
			countDownLatch4.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		endTime = System.currentTimeMillis();

		System.out.println("静态内部类式 执行 "+ executeNum +" 次 总耗时：" + (endTime - startTime) + " ms");

	}
}
