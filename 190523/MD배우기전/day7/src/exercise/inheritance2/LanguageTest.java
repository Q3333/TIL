package exercise.inheritance2;

public class LanguageTest {

	public static void main(String[] args) {
		//상속관계가 있는 경우 부모로 타입 선언을 함.
		Language k = new Korean();
		Language e = new English();
		Language j = new Japanese();
		
		k.sayHello();
		e.sayHello();
		j.sayHello();
		
		System.out.println(k.region);
		System.out.println(e.region);
		System.out.println(j.region);
		
		

	}

}
