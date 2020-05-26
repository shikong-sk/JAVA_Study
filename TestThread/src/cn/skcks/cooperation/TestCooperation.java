package cn.skcks.cooperation;

/*
    并发协作

    生产者消费者 模式

    管程法
    借助缓冲区实现
 */
public class TestCooperation {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(10);
        new Producers(buffer).start();
        new Consumers(buffer).start();
    }

    // 生产者
    static class Producers extends Thread {
        Buffer buffer;

        public Producers(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            // 生产
            for (int i = 1; i <= 100; i++) {
                System.out.println("生产 => 产品：" + i);
                buffer.push(new Product(i));
            }
        }
    }

    // 消费者
    static class Consumers extends Thread {
        Buffer buffer;

        public Consumers(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            // 消费
            for (int i = 1; i <= 100; i++) {
                System.out.println("消费 => 产品：" + buffer.pop().id);
            }
        }
    }

    // 产品
    static class Product {
        int id;

        public Product(int id) {
            this.id = id;
        }
    }

    // 缓冲区
    static class Buffer {
        Product[] products;
        int count = 0;

        public Buffer(int productNum) {
            this.products = new Product[productNum];
        }

        public synchronized void push(Product product) {
            if (products.length == count) {
                try {
                    this.wait();    // 线程等待 阻塞
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                this.notifyAll();   // 唤醒所有线程
            }

            this.products[count++] = product;

        }

        public synchronized Product pop() {
            if (count == 0) {
                try {
                    this.wait();    // 线程等待 阻塞
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                this.notifyAll();   // 唤醒所有线程
            }

            return this.products[--count];

        }
    }
}
