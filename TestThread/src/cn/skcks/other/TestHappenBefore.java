package cn.skcks.other;

/*
    指令重排

    代码执行顺序与预期不一致

    提高性能
 */
public class TestHappenBefore {

    private static int var = 0;

    private static boolean flag = false;

    public static void main(String[] args) {

        for (int i = 0; i < 20; i++) {
            var = 0;
            flag = false;

            // 读取数据
            Thread A = new Thread(() -> {
                if (flag) {
                    var = 1;
                }

                // 发生指令重排
                if (var == 0) {
                    System.out.println(var + " " + flag);
                }
            });

            // 更改数据
            Thread B = new Thread(() -> {
                var = 1;
                flag = true;
            });

            A.start();
            B.start();

            try {
                A.join();
                B.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
