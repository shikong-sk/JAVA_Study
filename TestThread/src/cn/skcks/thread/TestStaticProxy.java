package cn.skcks.thread;

/*
    静态代理

    公共接口
    真实角色 和 代理角色
 */
public class TestStaticProxy {
    public static void main(String[] args) {
        new Robot(new My()).gotoSchool();
    }
}

interface Study{
    void gotoSchool();
}

// 真实角色
class My implements Study{
    @Override
    public void gotoSchool() {
        System.out.println("去上学");
    }
}
// 代理角色
class Robot implements Study{
    private final My target;

    public Robot(My target) {
        this.target = target;
    }

    @Override
    public void gotoSchool() {
        start();
        this.target.gotoSchool();
        stop();
    }

    private void start(){
        System.out.println("机器人启动");
    }

    private void stop(){
        System.out.println("机器人关闭");
    }
}