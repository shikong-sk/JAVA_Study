package cn.skcks.oop;
/*
 * Arrays ���鹤�����ʹ��
 */
import java.util.Arrays;

public class TestArrays {
	public static void main(String[] args) {
		int a[] = {100,20,30,10,50,15};
		
		System.out.println(a);
		
		System.out.println(Arrays.toString(a));
		
		Arrays.sort(a); // ����������� Comparable �ӿڵ�Ӧ��
		System.out.println(Arrays.toString(a));
		
		// ���ַ����� �������ȶ�����������򣩣���δ�ҵ�����Ϊ����
		System.out.println(" ��Ԫ�ص�����Ϊ��" + Arrays.binarySearch(a, 30)); 

	
		
	}
}
