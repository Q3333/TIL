package lab.java.basic;

public class InterfaceTest {

	public static void main(String[] args) {
		
		//Animal animal = new Animal();
			System.out.println(Animal.EYES); // static¼Ó¼º
			Animal animal = new Cat();
			animal.move();
			
			((Cat)animal).eat(); // down casting
			
	}

}
