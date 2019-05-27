package lab.java.core;

public class PolyTest extends ExtendsTest {
	
	public void method(Object o) {
		System.out.println(o.toString());
		if(o instanceof String) { // o가 스트링 타입인지 묻는 if문
			System.out.println("length : "+((String)o).length());
		}
		if(o instanceof Integer) {
			System.out.println("intValue : "+((Integer)o).intValue()); 
		}
			}
	
	public final static int PACKAGE = 1;
	public final static void method() {}
	//public abstract final void method2() {} //에러

	public static void main(String[] args) {
		PolyTest test = new PolyTest();
		
		//object 호출
		Object o = new Object(); 
		test.method(o);
		System.out.println();
		
		//string
		String s = new String("java");
		test.method(s);//파라미터 전달시 부모타입으로 UpCasting됩니다.
		System.out.println();
		
		//integer
		Integer integer = new Integer(100);
		test.method(integer); // UpCasting
		//UpCasting으로 전달받은 파라미터만 실제 객체로 DownCasting가능합니다.
		
		System.out.println();
		
		Object[] obj = {
				new String("Korea"),
				new Integer("100"),
				new Parent(),
				new Child(),
				new Double("0.5")
				
		};
		
		System.out.println(((String)obj[0]).substring(1,3));
		for(Object ob : obj) {
			System.out.println(ob.getClass());
		}

		lab.java.basic.Animal cat = new lab.java.basic.Cat();
		
	
	
	} // main end

} // class end
