package cn.skcks.oop;

import java.util.*;

/*
    存储表格数据

    每行使用 JavaBean
    存放到 Map 或 List中
 */
public class TestStoreData_2 {
    public static void main(String[] args) {
        Student student1 = new Student(1730502127,"时空");
        Student student2 = new Student(1730502101,"装逼犯");

        List<Student> list = new ArrayList<>();

        list.add(student1);
        list.add(student2);

        for (Student student:list) {
            System.out.println(student);
        }

        System.out.println("========================================");

        Map<Integer,Student> studentMap = new HashMap<>();

        studentMap.put(0,student1);
        studentMap.put(1,student2);

        Set<Integer> studentMapSet = studentMap.keySet();
        for (Integer key:studentMapSet) {
            System.out.println(key + " => " + studentMap.get(key));
        }

    }

}

// 完整的 JavaBean 需要 get 和 set 方法 和 一个无参构造器
class Student{
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
