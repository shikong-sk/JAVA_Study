package cn.skcks.javassist;

import javassist.*;

import java.io.File;

/*
	使用 javassist 生成一个新的类

	不支持 JDK 5.0 以后的新语法
	例：泛型 枚举 注解修改 等
	不支持 数组的初始化
	不支持 内部类 和 匿名类
	不支持 continue break 表达式
	不支持 多级继承关系
 */
public class Javassist {
	public static void main(String[] args) {
		// 类池
		ClassPool classPool = ClassPool.getDefault();
		// 要创建的类
		CtClass userClass =  classPool.makeClass("cn.skcks.javassist.User");

		// 创建属性(类成员)
		try {
			CtField idField = CtField.make("private int id;",userClass);
			CtField nameField = CtField.make("private String name;",userClass);
			userClass.addField(idField);
			userClass.addField(nameField);

			// 创建方法
			CtMethod getName = CtMethod.make("public String getName(){return name;}",userClass);
			CtMethod setName = CtMethod.make("public void setName(String name){this.name = name;}",userClass);
			CtMethod getId = CtMethod.make("public int getId(){return id;}",userClass);
			CtMethod setId = CtMethod.make("public void setId(int id){this.id = id;}",userClass);
			userClass.addMethod(getName);
			userClass.addMethod(setName);
			userClass.addMethod(getId);
			userClass.addMethod(setId);

			// 创建构造器
			CtConstructor emptyConstructor = new CtConstructor(new CtClass[]{},userClass);
			CtConstructor userConstructor = new CtConstructor(new CtClass[]{CtClass.intType, classPool.get("java.lang.String")},userClass);
			// setBody 中的传参 $0 => this,$1 => 参数1,$2 => 参数 2
			userConstructor.setBody("{this.id = $1;this.name = $2;}");
			userClass.addConstructor(emptyConstructor);
			userClass.addConstructor(userConstructor);

			// 将生成的类写入指定的工作空间内
			String path = System.getProperty("user.dir")  + File.separator + "src" + File.separator + "cn" + File.separator + "skcks" + File.separator + "javassist";
			userClass.writeFile(path);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
