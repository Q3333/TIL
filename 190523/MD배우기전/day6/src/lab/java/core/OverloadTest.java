package lab.java.core;

public class OverloadTest {
	public void plus(int a, int b) {
		System.out.println("(int,int)");
	}
	public void plus(double a, double b) {
		System.out.println("(double,double)");
	}
	
	protected String plus(String a, String b) {
		System.out.println("(String,String)");
		return null;
	}
	
	protected int plus(int a, int b, int c) {
		System.out.println("(int,int,int)");
		return a+b+c;
	}

	public static void main(String[] args) {
		OverloadTest a = new OverloadTest();
		a.plus(3, 4);
		a.plus(3.14, 5.32);
		a.plus(0.5f,'A');
		
		
		// char와 double중 double이 더 크므로 double,double이 소환됨.
		
	}

}
