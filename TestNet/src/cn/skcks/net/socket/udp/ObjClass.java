package cn.skcks.net.socket.udp;

import java.io.Serializable;

public class ObjClass implements Serializable {
    private transient String name;
    private String say;

    public ObjClass(){}

    public ObjClass(String name,String say){
        this.name = name;
        this.say = say;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSay() {
        return say;
    }

    public void setSay(String say) {
        this.say = say;
    }
}
