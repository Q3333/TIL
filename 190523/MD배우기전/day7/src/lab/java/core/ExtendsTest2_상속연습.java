package lab.java.core;

class Parent2 {
	public Parent2() {
		System.out.println(1);
		// 해결방법 1: 디폴트 생성자를 생성해서 에러 안뜸
	} 
	public Parent2(String talent) {
		System.out.println(2);
		//디폴트 생성자가 아닌 String인자를 가지는 생성자를 만들어서 아래에 에러가 뜸.
	}
}
class Child2 extends Parent2{ // 상속
	// jdk가 컴파일 시 디폴트 생성자를 만들어줌
	public Child2() {
		// super();//항상 자동으로 만들어짐, 부모 클래스의 디폴트 생성자를 호출하는 코드
		super("IT");// 해결방법 2: 위가 스트링 인자를 가진 생성자라서 따로 스트링"IT"를 넣어줌
		System.out.println(3);
	}
	public Child2(String talent) {
		// super()가 숨겨져있음. 부모클래스의 디폴트 생성자. -> 1
		System.out.println(4); // 인자를 가지는 자식 클래스의 생성자.
		
	}
	
}

public class ExtendsTest2_상속연습{
	public static void main(String[] args) {
		Child2 c2 = new Child2();
		Child2 c3 = new Child2("DB");
	}
}