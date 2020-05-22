package cn.skcks.thread;

/*
    Lambda 表达式

    单个方法的接口 可使用 lambda

    带参数 lambda
    带返回值 lambda
 */
public class TestLambda_4 {
    public static void main(String[] args) {
        Money moneyObject;

        moneyObject = (String name, long money) -> {
            System.out.println(name + " 有 " + money + " 元");
            return money;
        };

        moneyObject.money("时空",100);

        // 简化 return
        moneyObject = (String name, long money) -> money;

        System.out.println(moneyObject.money("时空",100));

    }
}

interface Money {
    long money(String name, long money);
}

class MyMoney implements Money {
    @Override
    public long money(String name, long money) {
        System.out.println(name + "有" + money + "元");
        return money;
    }

}