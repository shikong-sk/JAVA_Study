import java.util.Scanner;
/**
 * 
 * @author Shikong
 *
 */
public class TestScanner {
	public static void main(String[] args) {
		System.out.println("���������֣�");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		
		System.out.println("���������䣺");
		int age = scanner.nextInt();
		
		System.out.println("##################");
		System.out.println(name);
		System.out.println(age);
		
		scanner.close();
	}
}
