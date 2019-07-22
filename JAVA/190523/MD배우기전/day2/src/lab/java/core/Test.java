package lab.java.core;

public class Test {
	//속성 +기능
	int a; //멤버변수, 인스턴스 변수
	public static void main(String[] args) {
		int b; // 로컬변수 = 초기화가 반드시 필요함
		System.out.println("Test");
		
		//System.out.println(b); // 초기화를 안해서 오류
		//b=20130; 오류없는구문

		//System.out.println(a); // 객체 생성없이 사용해서 오류
		/* Test t = new Test(); // 객체생성
		t.a = 2032032;  		//객체. 속성으로 사용
		System.out.println(t.a); 오류 없는 구문 */
		
		byte aa = 3;
		
		int bb = (int)aa;
		System.out.println(bb);
	}

}
