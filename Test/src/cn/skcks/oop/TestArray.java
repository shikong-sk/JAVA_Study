package cn.skcks.oop;

public class TestArray {
	public static void main(String[] args) {
		String s1[] = { "000","111", "222", "333","444" };
		String s2[] = new String[10];
		
		/*
		 * 数组拷贝
		 */
		System.arraycopy(s1, 1, s2, 6, 2);

		for (int i = 0; i < s2.length; i++) {
			System.out.println(i + ":" + s2[i]);
		}

		s1 = testCopyDelete(s1,-1);
		
		for (int i = 0; i < s1.length; i++) {
			System.out.println(i + ":" + s1[i]);
		}
		
		s1 = testCopyDelete(s1,20);
		
		for (int i = 0; i < s1.length; i++) {
			System.out.println(i + ":" + s1[i]);
		}
		
		s1 = testCopyDelete(s1,2);
		
		for (int i = 0; i < s1.length; i++) {
			System.out.println(i + ":" + s1[i]);
		}
		
		s1 = testCopyAddItem(s1, new String[] {"123","321"});
		
		for (int i = 0; i < s1.length; i++) {
			System.out.println(i + ":" + s1[i]);
		}
		
		s1 = testCopyAddItem(s1, "666");
		
		for (int i = 0; i < s1.length; i++) {
			System.out.println(i + ":" + s1[i]);
		}
	}

	public static String[] testCopyDelete(String[] s,int index) {
		
		int oldLength = s.length;
		
		if (index < 0 || index > s.length-1) { // 判断是否合法，不合法则直接返回数组
			return s;
		}
		
		System.arraycopy(s, index+1, s, index, s.length-index-1); // 删除下标为index的元素
		
		for (int i = s.length-1; i < oldLength; i++) { // 将空闲位置置空
			s[i] = null;
		}
		
		return s;
	}
	
	public static String[] testCopyAddItem(String s[],String item[])
	{
		int srcIndex = -1;
		int itemIndex = -1;
		for(int i = 0;i<s.length;i++) // 循环遍历源数组中是否有空位，有则先填满空位，再扩容数组
		{
			if(s[i] == null)
			{
				srcIndex = i;
				break;
			}
		}
		for(int i = 0;i<item.length;i++)
		{
			if(item[i] == null)
			{
				itemIndex = i;
				break;
			}
		}
		
		if(srcIndex == -1) srcIndex = s.length;
		if(itemIndex == -1) itemIndex = item.length;
		
		String tmp[] = new String[srcIndex + itemIndex];
		
		System.arraycopy(s, 0, tmp, 0, srcIndex);
		System.arraycopy(item, 0, tmp, srcIndex, itemIndex);
		
		return tmp;
	}
	
	public static String[] testCopyAddItem(String s[],String item)
	{
		int srcIndex = -1;
		for(int i = 0;i<s.length;i++)
		{
			if(s[i] == null)
			{
				srcIndex = i;
				break;
			}
		}
		
		if(srcIndex == -1) srcIndex = s.length;
		
		String tmp[] = new String[srcIndex + 1];
		System.arraycopy(s, 0, tmp, 0, srcIndex);
		
		tmp[srcIndex] = item;
		
		return tmp;
	}
}
