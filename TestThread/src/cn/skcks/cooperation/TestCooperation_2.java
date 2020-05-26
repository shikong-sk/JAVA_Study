package cn.skcks.cooperation;

/*
    并发协作

    生产者消费者 模式

    信号灯法
    借助标志位实现

    一对一
 */
public class TestCooperation_2 {
    public static void main(String[] args) {
        Product product = new Product();
        new Producers(product).start();
        new Consumers(product).start();
    }

    // 生产者
    static class Producers extends Thread {
        Product product;

        public Producers(Product product) {
            this.product = product;
        }

        @Override
        public void run() {
            // 生产
            for (int i = 0; i < 10; i++) {
                product.push(i % 2);
            }
        }
    }

    // 消费者
    static class Consumers extends Thread {
        Product product;

        public Consumers(Product product) {
            this.product = product;
        }

        @Override
        public void run() {
            // 消费
            for (int i = 0; i < 10; i++) {
                product.pop();
            }
        }
    }

    // 产品
    static class Product {
        int id;
        // true     为生产
        // false    为消费
        boolean flag = true;

        // 生产
        public synchronized void push(int id) {
            if (!flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("生产了产品：" + id);
            this.id = id;
            this.flag = false;
            this.notifyAll();
        }

        // 消费
        public synchronized void pop() {
            if (flag) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("消费了产品：" + id);
            this.flag = true;
            this.notifyAll();
        }
    }

}
