package lab.java.basic;

public class AnnoymousTest {

	public static void main(String[] args) {
		//public class Bird implements Animal 같은 선언 없이
		//생성과 동시에 구현이 되는 클래스 = 익명클래스
		Animal bird = new Animal() {//익명 클래스 시작
			
			public void move() {
				System.out.println("난다");
			}
			
			public void eat() {// 추가는 되는데 호출이 안댐
				System.out.println("벌레");
			}
		
		};//익명 클래스 끄으으읕
		
		bird.move();
		//bird.eat(); // Animal interface에서 선언이 안되어있어서 안댐
					// 이름이 없어서 캐스팅도 안댐
		
	
	}
		
}


