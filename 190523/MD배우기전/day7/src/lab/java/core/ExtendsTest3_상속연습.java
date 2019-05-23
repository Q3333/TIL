package lab.java.core;

class Parent3 {
		int age = 55;
	} 
	

class Child3 extends Parent3{ // 상속
	int age = 26; // 부모로부터 상속 받아도 동일한 이름의 변수 선언 가능.
				  // 이 경우 우선순위는 자식 클래스의 변수
	public void printAge() {
		int age = 23; //로컬 변수라서 다시 선언 가능
		System.out.println(age); // 가장 가까운 범위(scope)에서 검색 ->23
		System.out.println(this.age); // 메서드의 멤버인 속성을 읽기 ->26
		System.out.println(super.age); //상속받은 속성을 읽기 ->55
		//this처럼 상속받은 부모의 클래스를 참조하는 변수가 super(자동생성)
	}
	
	
}

public class ExtendsTest3_상속연습{
	public static void main(String[] args) {
		Child3 c = new Child3();
		c.printAge();
	}
}