package cn.skcks.oop;

import java.util.Arrays;

public class TestArrayTableData {
	public static void main(String[] args) {
		Object[] data1 = {10000,"aaa",18};
		Object[] data2 = {10001,"bbb",20};
		Object[] data3 = {10002,"ccc",16};
		
		Object tableData[][] = new Object[3][];
		
		tableData[0] = data1;
		tableData[1] = data2;
		tableData[2] = data3;
		
//		System.out.println(Arrays.deepToString(tableData));
		
		for(Object[] tmp:tableData)
		{
			System.out.println(Arrays.toString(tmp));
		}
	}
}
