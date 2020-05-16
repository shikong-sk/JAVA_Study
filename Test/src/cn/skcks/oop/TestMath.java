package cn.skcks.oop;

import java.util.Random;

public class TestMath {
	public static void main(String[] args) {
		System.out.println(Math.E);
		System.out.println(Math.PI);
		
		System.out.println(Math.ceil(3.14));
		System.out.println(Math.floor(3.14));
		
		System.out.println(Math.round(Math.PI));
		System.out.println(Math.round(Math.E));
		
		System.out.println(Math.abs(-45));
		
		System.out.println(4 << 3); // 4 * (2 的3次方)
		System.out.println(32 >> 3); // 32 / (2 的3次方)
		
		System.out.println(Math.pow(8, 2));
		System.out.println(Math.sqrt(64));
		
		System.out.println(Math.random());
		
		Random random = new Random();
		System.out.println(random.nextDouble());
		System.out.println(random.nextFloat());
		System.out.println(random.nextBoolean());
		System.out.println(random.nextInt(5));
		
		System.out.println(20 + random.nextInt(10)); // [20,30)
		System.out.println(20 + (int)(random.nextDouble() * 10)); // [20,30) 较为复杂的算法
		
	}
}
