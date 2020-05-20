package cn.skcks.io;

import java.io.*;

/*
    对象流

    序列化 与 反序列化

    读取顺序 与 写出顺序 必须一致
    不是所有的对象都可以序列化

    目标对象 需要实现 java.io.Serializable 类才能被序列化
 */
public class TestObjectStream_1 {
    public static void main(String[] args) {
        // 写出
        // 序列化
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(byteArrayOutputStream));

            objectOutputStream.writeUTF("123 abc 时空");
            objectOutputStream.writeInt(123456);
            objectOutputStream.writeBoolean(true);

            // 对象数据
            objectOutputStream.writeObject("String Object");
            objectOutputStream.writeObject(new CustomObject("时空","旅行者"));

            objectOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //
        byte[] data = byteArrayOutputStream.toByteArray();

        // 读取
        // 反序列化
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(data)));

            String data1 = objectInputStream.readUTF();

            int data2 = objectInputStream.readInt();

            boolean data3 = objectInputStream.readBoolean();

            System.out.println(data1 + "\n" + data2 + "\n" + data3);

            Object data4 = objectInputStream.readObject();
            if (data4 instanceof String)
            {
                String data4Obj = (String) data4;
                System.out.println(data4Obj);
            }

            Object data5 = objectInputStream.readObject();
            if (data5 instanceof CustomObject)
            {
                CustomObject data5Obj = (CustomObject) data5;
                System.out.println(data5Obj);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class CustomObject implements Serializable{

    // transient 不对此变量进行序列化
    public transient String name;

    public String info;

    public CustomObject() {
    }

    public CustomObject(String name, String info) {
        this.name = name;
        this.info = info;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "CustomObject{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}