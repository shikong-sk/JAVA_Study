package cn.skcks.io;

/*
    装饰器
 */
public class TestDecorate_1 {
    public static void main(String[] args) {
        Person person = new Person();
        person.say();

        // 装饰
        Amplifier amplifier = new Amplifier(new Person());
        amplifier.say();
    }
}

interface Say{
    void say();
}

class Person implements Say{

    private int voice = 20;

    @Override
    public void say() {
        System.out.println(getClass().toString().split("\\.")[3] + "\t voice :" + voice);
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }
}

// 装饰类
class Amplifier implements Say{

    private Person person;
    public Amplifier(Person person) {
        this.person = person;
    }

    @Override
    public void say() {
        System.out.println(getClass().toString().split("\\.")[3] + "\t voice :" + person.getVoice() * 2);
    }
}
