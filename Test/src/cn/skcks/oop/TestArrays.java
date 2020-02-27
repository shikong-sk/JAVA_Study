package cn.skcks.oop;
/*
 * Arrays 数组工具类的使用
 */
import java.util.Arrays;

public class TestArrays {
	public static void main(String[] args) {
		int a[] = {100,20,30,10,50,15};
		
		System.out.println(a);
		
		System.out.println(Arrays.toString(a));
		
		Arrays.sort(a); // 数组的排序是 Comparable 接口的应用
		System.out.println(Arrays.toString(a));
		
		// 二分法查找 （必须先对数组进行排序），若未找到则结果为负数
		System.out.println(" 该元素的索引为：" + Arrays.binarySearch(a, 30)); 

	
		
	}
}
