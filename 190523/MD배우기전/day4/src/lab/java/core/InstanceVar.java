package lab.java.core;

public class InstanceVar {
	int a = 100;
	public static void main(String[] args) {
		InstanceVar iv = new InstanceVar();
		System.out.println(iv.a);
		iv.a /=5;
		System.out.println(iv.a);
		
		InstanceVar iv2 = new InstanceVar();
		System.out.println(iv2.a);
		iv2.a %=5;
		System.out.println(iv2.a);
		
		iv = new InstanceVar();
		System.out.println(iv.a);
		iv.a /=50;
		System.out.println(iv.a);
	}

}
