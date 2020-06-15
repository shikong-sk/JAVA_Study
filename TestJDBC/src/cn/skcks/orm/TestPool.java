package cn.skcks.orm;

import cn.skcks.orm.classPackage.QueryFactory;
import cn.skcks.orm.classPackage.TableManager;
import cn.skcks.orm.interfacePackage.Query;
import cn.skcks.orm.utils.ReflectUtils;

import java.lang.reflect.Field;

/**
 * @author Shikong
 */
public class TestPool {

	private final static Class<?> studentClz = TableManager.classLoader("ms_student");

	public static void test(){
		if (studentClz == null) {
			throw new RuntimeException("目标类不存在");
		}

		Query query = QueryFactory.createQuery();

//		StringBuilder print = new StringBuilder();

		for(Object obj : query.queryRows("SELECT studentId,studentName FROM ms_student",studentClz,new Object[]{}))
		{
			for(Field field:studentClz.getDeclaredFields())
			{
				Object data = ReflectUtils.invokeGet(obj,field.getName());

				if(data != null)
				{
					System.out.println(field.getName() + " => " + data);

//					print.append(field.getName()).append(" => ").append(data).append("\n");
				}

			}
			System.out.println();

//			System.out.println(print);
		}
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 5000; i++) {
			test();
		}

		// 无连接池 12998 ms
		//   连接池  1524 ms
		System.out.println("耗时：" + (System.currentTimeMillis() - startTime) + " ms");
	}
}