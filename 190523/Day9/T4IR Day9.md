# T4IR 9일차 #

## Hero 연습 - interface, abstract, extends

- ## `SuperMan.java`

```java
package erercise.overall.hero;

public class SuperMan extends Hero {
	void action() {
		this.fly();
		this.swim();
		this.fight();
	}
	public String toString() {
		return ("슈퍼맨");
	}
}
```

- ## `Batman.java`

```java
package erercise.overall.hero;

public class BatMan extends Hero {
	public void action() {
		this.swim();
		this.fight();
	}
	public String toString() {
		return ("배트맨");
	}
	
	
}

```

- ## `SpiderMan.java`

```java
package erercise.overall.hero;

public class SpiderMan extends Hero {
	void action() {
		this.fight();
	}
	public String toString() {
		return ("스파이더맨");
	}
}
```



- ## `CanFight.java`

``` 
package erercise.overall.hero;

public interface CanFight {
	public void fight();
}

```

- ## `CanFly.java`

```
package erercise.overall.hero;

public interface CanFly {
	public void fly();
}

```

- ## `CanSwim.java`

```
package erercise.overall.hero;

public interface CanSwim {
	public void swim();
}

```

- ## `Hero.java`

```
package erercise.overall.hero;

public abstract class Hero implements CanFly, CanSwim, CanFight {
	public void fly() {
		System.out.println(this.toString()+"이 난다.");
	}
	public void fight() {
		System.out.println(this.toString()+"이 헤엄친다");
	}
	public void swim() {
		System.out.println(this.toString()+"이 싸운다.");
	}
	abstract void action();
}
```

- ## `HeroTest.java`

```
package erercise.overall.hero;

import java.util.Arrays;

public class HeroTest {

	public static void main(String[] args) {
		Hero[] heros = new Hero[] {
				new SuperMan(),
				new BatMan(),
				new SpiderMan() };
	
		System.out.print("Hero 목록 : ");
		System.out.println(Arrays.toString(heros));
		
		for(Hero num : heros) {
			num.action();
		}
	}	// main end
} // class end
```

![](C:\Users\student\TIL\190523\Day9\출력1.png)



Interface와 abstract, extends 의 개념을 익히는 예제 

