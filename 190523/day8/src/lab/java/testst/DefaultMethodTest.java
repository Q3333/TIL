package lab.java.testst;

public class DefaultMethodTest {

	public static void main(String[] args) {
		Child c = new Child();
		c.method1();

	}

}

class Child extends Parent implements MyInterface, MyInterface2{
	public void method1() {
		System.out.println("method1 () in Child");
	}
	
}

class Parent{
	public void method2 () {
	System.out.println("method2() in Parent");
	}
}

interface MyInterface {
	default void method1 () {
		System.out.println("method1 () in MyInterface");
	}
}


interface MyInterface2 {
	default void method1 () {
		System.out.println("method1 () in MyInterface2");
	}
}
