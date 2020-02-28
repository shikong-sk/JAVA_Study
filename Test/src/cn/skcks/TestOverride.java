package cn.skcks;

public class TestOverride {
	public static void main(String[] args) {
		TestOverride t = new TestOverride();
		System.out.println(t);
		System.out.println(t.toSuperString());

		User u1 = new User(1000, "时空");
		User u2 = new User(1000, "时空_Sk");
		System.out.println(u1 == u2);
		System.out.println(u1.equals(u2));
		
		String s1 = new String("123");
		String s2 = new String("123");
		
		System.out.println(s1 == s2);
		System.out.println(s1.equals(s2));

	}

	@Override
	public String toString() {
		return getClass().getName() + ".Shikong";
	}
	
	public String toSuperString() {
		return super.toString();
	}
}

class User {
	int id;
	String name;

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

}