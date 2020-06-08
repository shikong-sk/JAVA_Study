package cn.skcks.iterator.interfacePackage;

public interface Iterator {
	// 将 游标 指向 第一个 元素
	void first();

	// 将 游标 指向 下一个 元素
	void next();

	// 是否有下一个元素
	boolean hasNext();

	// 是否为第一个
	boolean isFirst();

	// 是否为最后一个
	boolean isLast();

	// 获取当前游标指向的对象
	Object getCurrentObj();
}
