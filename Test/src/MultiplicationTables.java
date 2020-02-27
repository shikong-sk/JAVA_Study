
public class MultiplicationTables {
	public static void main(String[] args) {
		for(int y=1;y<=9;y++)
		{
			for(int x=y;x<=9;x++)
			{
				System.out.print(y + "*" + x + '=' + x*y + '\t');
			}
			System.out.print('\n');
		}
		
		for(int x=1;x<=9;x++)
		{
			for(int y=1;y<=x;y++)
			{
				System.out.print(y + "*" + x + '=' + x*y + '\t');
			}
			System.out.print('\n');
		}
	}
}
