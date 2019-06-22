package lab.java.core;

public class VariableTest {
	int a;
	final int B = 2;
	static int c;
	
		public static void main(String[] args) {
			VariableTest test = new VariableTest();
			System.out.println(test.a);
			System.out.println(test.B);
			System.out.println(test.c++);
			System.out.println(VariableTest.c++); //객체 생성없이 클래스 이름으로 생성 가ㅡㄴㅇ
			System.out.println(c++); // 객체 참조 없이 그냥도 사용 가능
	}

}
