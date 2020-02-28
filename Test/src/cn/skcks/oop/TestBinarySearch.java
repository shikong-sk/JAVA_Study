package cn.skcks.oop;

import java.util.Arrays;

/*
 * 二分法查找
 */
public class TestBinarySearch {
	public static void main(String[] args) {
		int values[] = { 3, 1, 6, 2, 9, 0, 7, 4, 5, 8 };

//		int values[] = { 30,20,50,10,80,9,7,12,100,40,8};

		int search = 6;
		Arrays.sort(values);

		System.out.println(Arrays.toString(values));
		System.out.println("索引值为：" + Search(values, search));

	}

	public static int Search(int values[], int search) {
		int low = 0;
		int high = values.length - 1;

		while (low <= high) {
			int mid = (low + high) / 2;

			if (search == values[mid]) {
				return mid;
			}

			if (search > values[mid]) {
				low = mid + 1;
			} 
			if (search < values[mid]) {
				high = mid - 1;
			}

			System.out.println(low + "" + mid + high);
		}
		return -1;
	}
}
