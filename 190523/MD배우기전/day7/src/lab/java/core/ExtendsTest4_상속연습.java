package lab.java.core;

class Parent4 {
		
	} 
	

class Child4 extends Parent4{ // 상속
	
	}
	
class Child1 extends Parent4{
	
}


public class ExtendsTest4_상속연습{
	public static void main(String[] args) {
		Child4 c4 = new Child4();
		Child1 c1 = new Child1();
		Parent4 p4 = new Parent4();
		// 레퍼런스변수(객체) instanceof 타입(클래스명,인터페이스명)
		//인터페이스는 아직 안배움
		// 이 클래스가 원형이냐 or 상속을 받았냐 를 물어보는 연산자
		// return 은 true false
		System.out.println(c4 instanceof Child4); // is a 관계 체크
		System.out.println(c4 instanceof Parent4); // 상속 관계 체크
		System.out.println(p4 instanceof Child4); // 부모는 자식을 상속받은게 
												  //아니라서 false가 출력
//		System.out.println(c1 instanceof Child4); // 부모만 같지 상속관계가 없기
												  //때문에 아예 컴파일 오류가 출력됨.
		
	}
}