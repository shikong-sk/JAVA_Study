package cn.skcks.t;

public class TestForeach {
	public static void main(String[] args) {
		int a[] = new int[10];
		
		for(int i = 0;i<10;i++)
		{
			a[i] = i;
		}
		
		for(int t:a)
		{
			System.out.println(t);
		}
	}
}
