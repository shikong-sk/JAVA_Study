package cn.skcks.oop;

import java.util.Arrays;

/*
 * 二维数组
 */
public class Test2DimensionArray {
	public static void main(String[] args) {
//		int a[] = new int[3];
		
		int a[][] = new int[3][]; // 二维数组的动态初始化
		
		a[0] = new int[]{10,20,30};
		a[1] = new int[]{40,50};
		a[2] = new int[]{60};
		
		System.out.println(Arrays.deepToString(a)); // 深度遍历多维数组内容，将数组转为String
		
		int b[][] = { //二维数组的静态初始化
				{70,80,90},
				{100,1000},
				{10000}
		};
		
		System.out.println(Arrays.deepToString(b));
		
	}
}

class Car{
	
}