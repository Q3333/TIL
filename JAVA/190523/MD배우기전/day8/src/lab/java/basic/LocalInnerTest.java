package lab.java.basic;


class Outer3{
	private int outVar = 5;
	
	public void outerMethod() {
		method();
		//Inner inner = new Inner(); 위에서 이미 GC되어버려서 메모리에서 사라짐. 그래서 안댐
		
	}
	
	public void method() {
		int local = 10; // inner class에서 참조가 될 경우, 자동으로
						// final int local = 10; 으로 변환됨.(final추가)
		class Inner { // Local Inner Class
			public void innerMethod() {
				System.out.println("local = "+local);
				//local +=3;
				//Local Inner Class가 참조하는 local변수는 final이어야 합니다.
			}
		}
		
		Inner inner = new Inner();
		inner.innerMethod();
	}
	
}
	
	
public class LocalInnerTest {

	public static void main(String[] args) {
		Outer3 outer = new Outer3();
		outer.method();
	}

}
