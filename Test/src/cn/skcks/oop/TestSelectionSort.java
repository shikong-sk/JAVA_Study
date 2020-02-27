package cn.skcks.oop;

import java.util.Arrays;

public class TestSelectionSort {
	public static void main(String[] args) {
		int values[] = { 3, 1, 6, 2, 9, 0, 7, 4, 5, 8 };
		int tmp;
		
		for (int i = 0; i < values.length - 1; i++) {
			int min = i;
			for (int j = i+1; j < values.length; j++) {
				if(values[j] < values[min])
				{
					min = j;
				}
			}
			if (min != i) {
				tmp = values[i];
				values[i] = values[min];
				values[min] = tmp;
			}
			System.out.println(Arrays.toString(values));
		}
		System.out.println(Arrays.toString(values));
	}
}
