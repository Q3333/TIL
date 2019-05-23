package lab.java.core;

class Constructor {
	public Constructor (int a) {
		System.out.println("1");
	}
	public Constructor (int a, String b) {
		System.out.println("2");
	}
	public Constructor (String b, int a) {
		System.out.println("3");
	}
	public Constructor (String b, double a) {
		System.out.println("4");
	}
}

public class ConstructorTest {

	public static void main(String[] args) {
		Constructor c1 = new Constructor("100",3);
		Constructor c2 = new Constructor("100",3.0);
		Constructor c3 = new Constructor(3);
		Constructor c4 = new Constructor(3);
		
		
	}

}
