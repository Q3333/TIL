package lab.java.core;

public class VarTest {
	public int member;
	
	public void method() {
		int local = 3;
		//클래스 내에서 멤버들간에는 객체 생성 없이 참조 사용 가능합니다.
		System.out.println(member);
		//System.out.println(local);//초기화를 안해주었기 때문에 에러
	}
	
	public void method2() {
		method();
		//System.out.println(local); //local변수는 외부에서 참조가 불가능함.
	}
	
	public static void main(String[] args) {
		
		VarTest test = new VarTest();
		
		System.out.println(test.member);//main은 VarTest의 멤버가 아님.

	}

}
