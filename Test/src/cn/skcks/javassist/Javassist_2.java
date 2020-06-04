package cn.skcks.javassist;

import cn.skcks.javassist.annotation.Author;
import javassist.*;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Arrays;

/*
	测试 javassist API
 */
public class Javassist_2 {

	public static void basic() {
		try {
			// 处理类的基本用法
			ClassPool classPool = ClassPool.getDefault();
			CtClass userClass = classPool.get("cn.skcks.javassist.bean.User");

			// 获取字节码
			byte[] userClassBytes = userClass.toBytecode();
			System.out.println(Arrays.toString(userClassBytes));

			// 获取类名
			System.out.println(userClass.getName());
			// 获取简要类名
			System.out.println(userClass.getSimpleName());
			// 获取父类
			System.out.println(userClass.getSuperclass());
			// 获取接口
			System.out.println(Arrays.toString(userClass.getInterfaces()));


		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public static void addNewMethod() {
		try {

			// 添加新的方法
			ClassPool classPool = ClassPool.getDefault();
			CtClass userClass = classPool.get("cn.skcks.javassist.bean.User");

//			CtMethod method = CtNewMethod.make("public int add(int a,int b){return a+b;}",userClass);

			// 返回值类型 方法名 参数 类
			CtMethod method = new CtMethod(CtClass.intType, "add", new CtClass[]{CtClass.intType, CtClass.intType}, userClass);
			// 设置 方法 访问修饰符
			method.setModifiers(Modifier.PUBLIC);
			method.setBody("{return $1+$2;}");
			// 将新的方法添加到类中
			userClass.addMethod(method);


			// 通过反射调用新生成的方法
			Class<?> clz = userClass.toClass();
			Object classObj = clz.newInstance(); // 调用无参构造器 创建 新对象
			Method newMethod = clz.getDeclaredMethod("add", int.class, int.class);
			// 执行方法 并 获取返回值
			Object res = newMethod.invoke(classObj, 1, 2);
			System.out.println(res);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void modMethod() {
		try {
			// 修改已有的方法
			ClassPool classPool = ClassPool.getDefault();
			CtClass userClass = classPool.get("cn.skcks.javassist.bean.User");

			CtMethod method = userClass.getDeclaredMethod("say", new CtClass[]{classPool.get("java.lang.String")});
			method.insertBefore("System.out.println(\"通过动态修改方法 添加到方法之前\");");
			method.insertAfter("System.out.println(\"通过动态修改方法 添加到方法之后\");");
			// 通过反射调用新生成的方法
			Class<?> clz = userClass.toClass();
			Object classObj = clz.newInstance(); // 调用无参构造器 创建 新对象
			Method newMethod = clz.getDeclaredMethod("say", String.class);
			// 执行方法 并 获取返回值
			Object res = newMethod.invoke(classObj, "时空");
			System.out.println(res);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addField() {
		try {
			// 添加新属性(成员)
			ClassPool classPool = ClassPool.getDefault();
			CtClass userClass = classPool.getCtClass("cn.skcks.javassist.bean.User");

//			CtField newField = CtField.make("public String info = \"动态添加属性\"",userClass);

			// 设置 属性类型 属性名
			CtField newField = new CtField(classPool.get("java.lang.String"), "msg", userClass);
			// 设置 属性 访问修饰符
			newField.setModifiers(Modifier.PUBLIC);
			// 添加到类中 并 赋予初始值
//			userClass.addField(newField);
			userClass.addField(newField, CtField.Initializer.constant("动态添加属性值"));
			// 为属性添加 get 和 set 方法
			userClass.addMethod(CtNewMethod.getter("getMsg", newField));
			userClass.addMethod(CtNewMethod.setter("getMsg", newField));

			// 将生成的类写入指定的工作空间内
			String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "cn" + File.separator + "skcks" + File.separator + "javassist";
			userClass.writeFile(path);


			// 通过反射获取指定的属性
			Class<?> clz = userClass.toClass();
			Object classObject = clz.newInstance();
			Method get = clz.getMethod("getMsg");
			Object res = get.invoke(classObject);
			System.out.println(res);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getConstructors(){
		try {
			ClassPool classPool = ClassPool.getDefault();
			CtClass userClass = classPool.getCtClass("cn.skcks.javassist.bean.User");

			// 获取所有构造器
			CtConstructor[] ctConstructors = userClass.getConstructors();
			for(CtConstructor constructor:ctConstructors){
				System.out.println(constructor.getLongName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			ClassPool classPool = ClassPool.getDefault();
			CtClass userClass = classPool.getCtClass("cn.skcks.javassist.bean.User");

			// 获取所有注解
			Object[] annotations = userClass.getAnnotations();
			for (Object annotation : annotations)
			{
				if(annotation instanceof Author)
				{
					System.out.println(((Author) annotation).name());
					System.out.println(((Author) annotation).year());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
