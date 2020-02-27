package cn.skcks.oop;

public class TestInterface2 {
	public static void main(String[] args) {
		Volant angelVolant = new Angel();
		angelVolant.fly();
		
		Honest angelHonest = new Angel();
		angelHonest.helpOther();
		
		GoodMan goodMan = new GoodMan();
		goodMan.helpOther();
	}
}

interface Volant{
	int FLY_HEIGHT = 1000;
	void fly();
}

interface Honest{
	void helpOther();
}

class Angel implements Volant,Honest{

	@Override
	public void helpOther() {
		// TODO Auto-generated method stub
		System.out.println("Angel.helpOther()");
		
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("Angel.fly()");
	}

}

class GoodMan implements Honest{

	@Override
	public void helpOther() {
		// TODO Auto-generated method stub
		System.out.println("GoodMan.helpOther()");
	}
	
}

class Bird implements Volant{

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("Bird.fly()");
	}
	
}
