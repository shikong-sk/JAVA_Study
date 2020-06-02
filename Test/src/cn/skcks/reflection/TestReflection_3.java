package cn.skcks.reflection;

import cn.skcks.reflection.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/*
	通过反射的 API,获取类的信息

	动态调用 类、属性、方法、构造器等
 */
class TestReflection_3 {
	public static void main(String[] args) {
		try {

			String path = "cn.skcks.reflection.bean.User";

			@SuppressWarnings({"unchecked"})
			Class<User> clz = (Class<User>) Class.forName(path);

			// 通过动态调用构造方法 构造对象
			User user = clz.newInstance();  // 调用无参构造方法
			System.out.println(user);
			// 手动指定构造器
			Constructor<User> userConstructor = clz.getDeclaredConstructor(int.class,String.class,int.class);
			User user2 = userConstructor.newInstance(1,"时空",20);
			System.out.println(user2.getName());

			// 通过 反射 API 调用普通方法
			Method setName = clz.getMethod("setName", String.class);
			setName.invoke(user2,"时空旅行者");
			Method getName = clz.getMethod("getName");
			System.out.println(getName.invoke(user2));

			// 通过反射 API 操作成员
			Field name = clz.getDeclaredField("name");
			// 不对此属性进行安全检查 提高反射的运行速度 无视访问修饰符 访问权限的限制
			name.setAccessible(true);
			name.set(user2,"时空");
			System.out.println(name.get(user2));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}