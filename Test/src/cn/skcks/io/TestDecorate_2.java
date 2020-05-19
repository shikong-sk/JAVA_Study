package cn.skcks.io;

/*
    装饰器

    抽象组件：需要装饰的抽象对象（接口 或 抽象父类）
    具体组件：需要装饰的对象
    抽象装饰类：包含对抽象组件的引用以及装饰着共有的方法
    具体装饰类：被装饰的对象
 */
public class TestDecorate_2 {
    public static void main(String[] args) {
        Drink coffee = new Coffee();

        Drink sugar = new Sugar(coffee);
        System.out.println(sugar.info() + " => " + sugar.cost());

        Drink milk = new Milk(coffee);
        System.out.println(milk.info() + " => " + milk.cost());

        milk = new Milk(sugar);
        System.out.println(milk.info() + " => " + milk.cost());
    }
}

// 抽象组件
interface Drink{
    double cost();
    String info();
}

// 具体组件
class Coffee implements Drink{
    private String name = "咖啡";

    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String info() {
        return name;
    }
}

// 抽象装饰类
abstract class Decorate implements Drink{
    private Drink drink;

    public  Decorate(Drink drink)
    {
        this.drink = drink;
    }

    @Override
    public double cost() {
        return this.drink.cost();
    }

    @Override
    public String info() {
        return this.drink.info();
    }
}

// 具体装饰类
class Milk extends Decorate{
    public Milk(Drink drink)
    {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost() + 4;
    }

    @Override
    public String info() {
        return super.info() + " 加牛奶";
    }
}

class Sugar extends Decorate{
    public Sugar(Drink drink)
    {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost() + 2;
    }

    @Override
    public String info() {
        return super.info() + " 加白糖";
    }
}