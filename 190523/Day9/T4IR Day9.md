# T4IR 9일차 #

## Animal 연습 - interface, abstract, extends

- ## `Cat.java`

```java
package exercise.animal;

public class Cat extends animal {
	void action() {
		this.hunt();
		this.eat();
		this.sleep();
	}
	public String toString() {
		return ("고양이");
	}
}
```

- ## `Bird.java`

```java
package exercise.animal;

public class Bird extends animal {
	public void action() {
		this.hunt();
		this.eat();
		this.sleep();
	}
	public String toString() {
		return ("새");
	}
	
	
}

```

- ## `Dog.java`

```java
package exercise.animal;

public class Dog extends animal {
	void action() {
		this.hunt();
		this.eat();
		this.sleep();
	}
	public String toString() {
		return ("강아지");
	}
}
```



- ## `Hunt.java`

``` 
package exercise.animal;

public interface Hunt{
	public void hunt();
}

```

- ## `Eat.java`

```
package exercise.animal;

public interface Eat {
	public void fly();
}

```

- ## `Sleep.java`

```
package exercise.animal;

public interface Sleep {
	public void sleep();
}

```

- ## `Animal.java`

```
package exercise.animal;

public abstract class Animal implements Eat, Hunt, Sleep {
	public void eat() {
		System.out.println(this.toString()+"이 먹는다.");
	}
	public void hunt() {
		System.out.println(this.toString()+"이 사냥한다.");
	}
	public void sleep() {
		System.out.println(this.toString()+"이 잔다.");
	}
	abstract void action();
}
```

- ## `AnimalTest.java`

```
package exercise.animal;

import java.util.Arrays;

public class AnimalTest {

	public static void main(String[] args) {
		Animal[] aimals = new Animal[] {
				new Cat(),
				new Dog(),
				new Bird() };
	
		System.out.print("Animal 목록 : ");
		System.out.println(Arrays.toString(animals));
		
		for(Animal num : animals) {
			num.action();
		}
	}	// main end
} // class end
```

Interface와 abstract, extends 의 개념을 익히는 예제 

