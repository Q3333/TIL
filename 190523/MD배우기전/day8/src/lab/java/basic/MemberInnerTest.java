package lab.java.basic;

class Outer{
	private int outVar = 5;
	public void outerMethod() {
		Inner inner = new Inner();
		System.out.println("inVar+="+inner.inVar);
	}
	
	protected class Inner {
		private int inVar = 10;
		public void inMethod() {
			System.out.println("outVar+="+outVar);
		}
	}
}

public class MemberInnerTest {

	public static void main(String[] args) {
		//Inner 努贰胶 积己规过1
		Outer.Inner abc = new Outer().new Inner();
		abc.inMethod();
		
		//Inner 努贰胶 积己规过2
//		Outer outer = new Outer();
//		Outer.Inner abc2 = outer.new Inner();

		Outer outer = new Outer();
		outer.outerMethod();
		
	}

}
