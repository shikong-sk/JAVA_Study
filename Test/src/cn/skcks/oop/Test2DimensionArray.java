package cn.skcks.oop;

import java.util.Arrays;

/*
 * ��ά����
 */
public class Test2DimensionArray {
	public static void main(String[] args) {
//		int a[] = new int[3];
		
		int a[][] = new int[3][]; // ��ά����Ķ�̬��ʼ��
		
		a[0] = new int[]{10,20,30};
		a[1] = new int[]{40,50};
		a[2] = new int[]{60};
		
		System.out.println(Arrays.deepToString(a)); // ��ȱ�����ά�������ݣ�������תΪString
		
		int b[][] = { //��ά����ľ�̬��ʼ��
				{70,80,90},
				{100,1000},
				{10000}
		};
		
		System.out.println(Arrays.deepToString(b));
		
	}
}

class Car{
	
}