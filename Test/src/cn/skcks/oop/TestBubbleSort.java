package cn.skcks.oop;

import java.util.Arrays;

/*
 * ð������
 */
public class TestBubbleSort {
	public static void main(String[] args) {

		int values[] = { 3, 1, 6, 2, 9, 0, 7, 4, 5, 8 };
		int tmp;

		/*
		 * ����д��
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
//			System.out.println("################ ������ " + (i+1) + " ������ ################");
//		}
		/*
		 * �Ż�д��
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
			
			System.out.println("################ ��ѭ�� " + (i + 1) + " �� ################");
			if (flag) { // ��һ����ѭ����û�з���������ֱ�ӽ�������
				System.out.println("################  �������   ################");
				break;
			}
		}

		System.out.println(Arrays.toString(values));

	}
}
