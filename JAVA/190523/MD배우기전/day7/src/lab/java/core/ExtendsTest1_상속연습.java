package lab.java.core;

class Parent {
	String name = "parent";
	private int money = 1000000000;
	public void work() {
		System.out.println("IT");
	}
	private void hobby() {
		System.out.println("2job");
	}
}
class Child extends Parent{ // 상속
	
//class Child extends Parent, Movie{ 에러 -> 단일 상속만 지원이 됨.
	
	
}

public class ExtendsTest1_상속연습{
	public static void main(String[] args) {
		
		Child c1 = new Child();
		System.out.println(c1.name);// 부모한테 상속받은 name
		c1.name = "child"; //상속을 받았어도 자기 자신의 멤버변수로 해서 변경 가능.
		System.out.println(c1.name);
		c1.work();// 부모로부터 상속받은 메소드
		
		// c1.money -> 부모의 private 속성은 상속 불가 
		// c1.hobby() -> 부모의 private 메소드는 상속 불가
	}
}