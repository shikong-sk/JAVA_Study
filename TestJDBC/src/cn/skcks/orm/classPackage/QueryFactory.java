package cn.skcks.orm.classPackage;

import cn.skcks.orm.interfacePackage.Query;

/*
	Query 工厂类
 */
// 反射方式
//public class QueryFactory {
//
//	private static  QueryFactory factory = new QueryFactory();
//
//	private static Class<?> queryClz;
//
//	static{
//		try {
//			queryClz = Class.forName(DbManager.getConfig().getQueryClass());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//
//	private QueryFactory(){}
//
//	public Query createQuery(){
//		try {
//			return (Query) queryClz.newInstance();
//		} catch (InstantiationException | IllegalAccessException e) {
//			e.printStackTrace();
//			return null;
//		}
//	}
//}

// 克隆方式

/**
 * SQL 语句构造工厂类
 */
public class QueryFactory {

	private static QueryOptimized queryObj;

	static{
		try {
			Class<?> queryClz = Class.forName(DbManager.getConfig().getQueryClass());

			queryObj = (QueryOptimized) queryClz.newInstance();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private QueryFactory(){}

	public static QueryOptimized createQuery(){
		try {
			return (QueryOptimized) queryObj.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw new RuntimeException("QueryFactory 加载失败");
//			return null;
		}
	}
}