package cn.skcks.oop;

import java.util.Arrays;

/*
 * 冒泡排序
 */
public class TestBubbleSort {
	public static void main(String[] args) {

		int values[] = { 3, 1, 6, 2, 9, 0, 7, 4, 5, 8 };
		int tmp;

		/*
		 * 基础写法
		 */
//		for (int i = 0; i < values.length; i++) {
//			for (int j = 0; j < values.length - 1 - i; j++) {
//				if(values[j] > values[j+1]) {
//					tmp = values[j];
//					values[j] = values[j+1];
//					values[j+1] = tmp;
//				}
//				System.out.println(Arrays.toString(values));
//			}
//			
//			System.out.println("################ 已排序 " + (i+1) + " 个数字 ################");
//		}
		/*
		 * 优化写法
		 */
		for (int i = 0; i < values.length; i++) {
			boolean flag = true;
			for (int j = 0; j < values.length - 1 - i; j++) {
				if (values[j] > values[j + 1]) {
					tmp = values[j];
					values[j] = values[j + 1];
					values[j + 1] = tmp;
					flag = false;
				}
				System.out.println(Arrays.toString(values));
			}
			
			System.out.println("################ 已循环 " + (i + 1) + " 次 ################");
			if (flag) { // 若一整个循环都没有发生交换则直接结束排序
				System.out.println("################  排序结束   ################");
				break;
			}
		}

		System.out.println(Arrays.toString(values));

	}
}
