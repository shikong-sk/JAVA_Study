package cn.skcks.orm.interfacePackage;

import sun.security.krb5.internal.tools.Klist;

import java.util.List;

public interface Query {

	/*
		执行 SQL DML 语句
	 */
	int executeDML(String sql, Object[] params);

	void insert(Object object);

	// 根据对应的表对象 指定的主键 删除
	int delete(Class<?> clz,Object object);

	void delete(Object object);

	int update(Object object,String[] fields);

	// 查询多行数据
	List<?> queryRows(String sql,Class<?> clz,Object[] params);

	Object queryRow(String sql,Class<?> clz,Object[] params);

	Object queryValue(String sql,Object[] params);

	Number queryNumberValue(String sql,Object[] params);
}
