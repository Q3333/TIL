package lab.java.core;

abstract class Animal{
	public abstract void move();
	public abstract void eat();
	//메모리에 객체를 넣으려면 구현을 해야함.
	public void sleep() {
		System.out.println("zzZZ....");
	}
}

class Dog extends Animal{
	public void move() {
		System.out.println("벌러덩");
	}
	
	public void eat() {
		System.out.println("잡식성");
	}
	
}

public class AbstractTest {

	public static void main(String[] args) {
		// Animal은 추상이여서 객체생성이 안되는데 Dog는 가능함.
		Dog dog = new Dog();
		Animal animal = new Dog();
		
		dog.sleep();
		dog.move();
		dog.eat();
		System.out.println("");
		animal.sleep();
		animal.move();
		animal.eat();
	}

}
