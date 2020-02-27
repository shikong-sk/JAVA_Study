import static cn.skcks.HelloWorld.*;

public class TestRecursion {

	public static void main(String[] args) {
		final long n = 3;
		
		System.out.println("�ݹ��㷨��");
		long t1 = System.currentTimeMillis();
		System.out.println( n + "�Ľ׳�Ϊ��" + recursive(n)); 
		long t2 = System.currentTimeMillis();
		System.out.println("��ʱ��"+ (t2-t1) + "ms");
		
		System.out.println();
		
		System.out.println("�����㷨��");
		
		long i = n;
		long res = i;
		
		t1 = System.currentTimeMillis();
		for(;i>1;i--)
		{
			System.out.println(n + "x" + (i-1) + "=" + (i * (i-1)) );
			res *= i-1;
		}
		System.out.println( n + "�Ľ׳�Ϊ��" + res);
		t2 = System.currentTimeMillis();
		System.out.println("��ʱ��"+ (t2-t1) + "ms");
		
		System.out.println('\n' + six());
		System.out.println(SIX);
	}
	
	static long recursive(long i) {
		if(i == 1)
		{
			return 1;
		}
		else
		{
			System.out.println(i+"x"+(i-1)+"="+i*(i-1)); 
			return i*recursive(i-1);
		}
	}
	
}
