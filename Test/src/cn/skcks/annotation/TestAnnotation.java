package cn.skcks.annotation;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CustomAnnotation
// 自定义 类 注解
public class TestAnnotation {
	public static void main(String[] args) {
		Annotation testAnnotation = new Annotation();

		testAnnotation.toString();
		Annotation.testDeprecated();

		@SuppressWarnings("deprecation")
		long date = Date.parse("2020/06/02");

		System.out.println(date);
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(new Long("1591074000000"))));
	}

	static class Annotation {
		@Override
		// 重写父类方法
		public String toString() {
			return "";
		}


		// 抑制警告信息
		// all                                          所有警告
		// boxing                                       抑制装箱、拆箱操作时的警告
		// deprecation                                  使用了过时方法时的警告
		// fallthrough                                  当在使用 switch 语句时发生 case 穿透
		// path                                         当在类路径、源文件路径中有不存在的路径时的警告
		// serial                                       当在可序列化的类上缺少 serialVersionUID 定义时的警告
		// finally                                      任何 finally 语句 不能完成时的警告
		// unchecked                                    忽略使用 List，ArrayList 等未进行参数化(泛型)产生的警告信息
		// unused                                       抑制未使用的变量的警告
		// rawtypes                                     忽略使用原始类型相关的警告
		// static-method                                忽略可以声明为静态方法的警告
		// javadoc                                      忽略 javadoc 的警告
		// unqualified-field-access	                    抑制没有权限访问的 类成员 的警告
		// cast                                         抑制映射相关的警告
		// dep-ann                                      抑制启用注释的警告

		// @SuppressWarnings(value={"path","all"})      多个值的写法

		@SuppressWarnings(value = {"all"})
		public void testSuppressWarnings() {
			List list = new ArrayList();
		}

		@Deprecated
		// 不推荐使用的方法、弃用的方法
		static public void testDeprecated() {
		}

		@CustomAnnotation(age = 20, name = "时空", str = {"a","b","c"})
		// 自定义 方法 注解
		public void CustomAnnotation() {
		}

		// 参数名为 value 时可省略 value =
//        @CustomAnnotationSimple(value = "ShiKong")
		@CustomAnnotationSimple("ShiKong")
		public void CustomAnnotationSimple() {
		}
	}

}
