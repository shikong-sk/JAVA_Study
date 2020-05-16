package cn.skcks.oop;

public class TestEnum {
	public static void main(String[] args) {
		System.out.println(Season.SPRING);
		
		Season aSeason = Season.AUTUMN;
		
		switch (aSeason) {
		case SPRING:
			System.out.println("春天！！！");
			break;
		default:
			System.out.println("不是春天");
			break;
		}
	}
}

enum Season{
	SPRING,SUMMER,AUTUMN,WINTER
}

enum Week{
	星期一,星期二,星期三,星期四,星期五,星期六,星期日
}