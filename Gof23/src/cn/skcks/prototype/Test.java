package cn.skcks.prototype;

import java.util.concurrent.CountDownLatch;

/*
	不同克隆方式效率测试

	克隆 效率 > new

	短时间创建大量相同对象 且 耗时 推荐 克隆
 */
public class Test {
	public static void main(String[] args) {
		final long startTime = System.currentTimeMillis();

		long time = 5000L;

		CountDownLatch countDownLatch = new CountDownLatch(Math.toIntExact(time));
		CountDownLatch countDownLatch2 = new CountDownLatch(Math.toIntExact(time));
		CountDownLatch countDownLatch3 = new CountDownLatch(Math.toIntExact(time));

		Laptop tmp = new Laptop();
		for (long i = 0; i < time; i++) {
			new Thread(()->{
				Laptop laptop = new Laptop();

				countDownLatch.countDown();
			}).start();


			new Thread(()->{
				try {
					Laptop laptop = (Laptop) tmp.clone();
				} catch (CloneNotSupportedException e) {
					e.printStackTrace();
				}

				countDownLatch2.countDown();
			}).start();

		}

		new Thread(()->{
			try {
				countDownLatch.await();

				long endTime = System.currentTimeMillis();
				System.out.println("new 方式 耗时：" + (endTime - startTime) + " ms");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(()->{
			try {
				countDownLatch2.await();

				long endTime = System.currentTimeMillis();
				System.out.println("克隆 方式 耗时：" + (endTime - startTime) + " ms");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

	}
}

class Laptop implements Cloneable{
	public Laptop() {
		try {
			// 模拟耗时操作
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}