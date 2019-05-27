package lab.java.core;

public class StaticTest {
	static int snum; //클래스 변수
	int num; // 인스턴스 변수
	
	public static void staticMethod() {
		snum++; // 클래스 변수 처리 가능
		//num++; // 인스터스 변수 처리 불가능
	}
	
	public void method() {
		snum++;
		num++;
	}
	
	public static void main(String[] args) {
		StaticTest test = new StaticTest();
		
		// method(); 객체 선언 필요
		// System.out.println(num); 객체 선언 필요
		
		test.method();
		System.out.println(test.num);
		
		staticMethod();
		System.out.println(snum);
		

	}

}
