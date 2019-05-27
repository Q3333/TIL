package lab.java.core;

public class Operator2 {

	public static void main(String[] args) {
		// 산술연산자 (*,/,+,-,%)
		int a = 5, b = 7;
		System.out.println(b%a);
		System.out.println(b/a); // 정수 나누기 정수는 정수결과를 리턴함.
		System.out.println((float)b/a); // 하나를 실수로 만들어주면 실수결과리턴.
		
		//문자열  + 모든 타입은 문자열로 결합됨.
		System.out.println("java"+8);
		System.out.println("java"+true);
	
	}

}
