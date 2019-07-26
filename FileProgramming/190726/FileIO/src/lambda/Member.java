package lambda;

public class Member {
	public static int MALE = 0;
	public static int FEMALE = 1;
	
	String name;
	int Sex;
	int age;
	
	
	
	public Member() {
		super();
	}
	public Member(String name, int sex, int age) {
		super();
		this.name = name;
		Sex = sex;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return Sex;
	}
	public void setSex(int sex) {
		Sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
}
