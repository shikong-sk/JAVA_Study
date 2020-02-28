import java.util.Scanner;
/**
 * 
 * @author Shikong
 *
 */
public class TestScanner {
	public static void main(String[] args) {
		System.out.println("请输入名字：");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		
		System.out.println("请输入年龄：");
		int age = scanner.nextInt();
		
		System.out.println("##################");
		System.out.println(name);
		System.out.println(age);
		
		scanner.close();
	}
}
