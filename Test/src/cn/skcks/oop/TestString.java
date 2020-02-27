package cn.skcks.oop;

public class TestString {
	public static void main(String[] args) {
		String str1 = "abc"; // String Ϊ���ɱ��ַ���
		String str2 = "abc"; // �Զ����볣����
		String str3 = new String("abc"); // �����Ĳ�ͬ�Ķ���
		
		System.out.println(str1 == str2);
		System.out.println(str1 == str3); // str1 �� str3 ����ͬһ������
		
		System.out.println(str3.equals(str1)); // ͨ��ʹ�� equals �Ƚ��ַ���
		
		String s1 = "core Java ";
		String s2 = "Core Java ";
		
		System.out.println(s1.charAt(0)); // ��ȡ�±�Ϊ 0 ���ַ�
		System.out.println(s1.equals(s2)); // �Ƚ��ַ����Ƿ����
		System.out.println(s1.equalsIgnoreCase(s2)); // �Ƚ��ַ����Ƿ���ȣ����Դ�Сд��
		
		System.out.println(s1.indexOf("Java")); // �����ַ����Ƿ���� Java ,���򷵻ز��ҵ����ַ����ĵ�һ���ַ����±�
		System.out.println(s1.indexOf("Shikong"));
		
		String s = s1.replace(" ", "&"); // ���ַ����еĿո��滻Ϊ &
		
		System.out.println(s);
		
		System.out.println(s1.startsWith("core")); // �Ƿ��� core ��ͷ
		System.out.println(s1.endsWith("shikong")); // �Ƿ��� shikong ��β
		
		s = s1.substring(5); // ��ȡ���ַ��������±�Ϊ5��ʼ���ַ�����βΪֹ
		System.out.println(s);
		
		s = s1.substring(5,8); // ��ȡ���ַ������±�5��8-1 (������8) ��Χ��[5,8)
		System.out.println(s);
		
		s = s1.trim(); // ȥ���ַ�����β���ߵĿո�
		System.out.println(s);
	}
}
