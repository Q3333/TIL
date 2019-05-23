package lab.java.basic;

import lab.java.basic.Outer.Inner;

class Outer2{
	private int outVar = 5;
	static int staticOutVar = 100;
	public void outerMethod() {
		Inner.innerMethod();
	}
	
	 static class Inner {
		public static void innerMethod() {
		//	System.out.println("outVar+="+outVar); // 에러(스태틱이아니라)
			System.out.println("staticOutVar+="+staticOutVar);
			
		}
	}
	 static class Inner2 {
		 static int staticInVar = 1;
	 }
}

public class StaticInnerTest {

	public static void main(String[] args) {
		//클래스가 스태틱이라서 그냥 이름으로 호출 가능
		Outer2.Inner.innerMethod();
		
		//Outer2 클래스는 스태틱이 아니라서 객체 생성이 필요함
		Outer2 outer = new Outer2();
		outer.outerMethod();

	}

}
