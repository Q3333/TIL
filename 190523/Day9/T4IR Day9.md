# T4IR 9일차 #

## Hero 연습 - interface, abstract, extends

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

- ## `CanFight.java`

  

``` 
package erercise.overall.hero;

public interface CanFight {
	public void fight();
}

```



