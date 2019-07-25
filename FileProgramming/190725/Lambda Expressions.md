# **Lambda Expressions**



함수적 프로그래밍 (함수의 매개변수에 함수를 넣는다던지)을 가능하게 해줌



**

### 함수적 인터페이스

함수적 인터페이스는 하나의 추상 메소드가 선언된 인터페이스

람다식의 타겟 타입이 될 수 있다



**java.util.function 패키지**



- **Consumer**

매개값은 있고, 리턴값은 없음

매개값을 소비하는 역할만 한다



- **Supplier**

매개값은 없고, 리턴값은 있음

호출한 곳으로 데이터를 리턴(공급)하는  역할을 한다.



- **Function**

매개값도 있고, 리턴값도 있음

매개값을 리턴값으로 매핑(타입 변환)하는 역할을 한다.



활용 예시 - 인터페이스

```java
package FileIO.lab.java;

public interface MyFunctionalInterface3 {
	public int method(int x , int y);

}
```





활용 예시 - 메인

```java
package FileIO.lab.java;

public class MyFunctionalInterfaceExam3 {
	
    public static void main(String[] args) {
        MyFunctionalInterface3 fi;
 
        fi = (x, y) -> {
            int result = x + y;
 
            return result;
        };
        System.out.println(fi.method(2, 5));
 
        fi = (x, y) -> {
            return x + y;
        };
        System.out.println(fi.method(2, 5));
       
        
        fi = (x, y) -> x + y;
        System.out.println(fi.method(2, 5));
 
        fi = (x, y) -> sum(x, y);
        System.out.println(fi.method(2, 5));
    }
 
    public static int sum(int x, int y) {
        return x + y;
    }
}

```



 fi = (x, y) -> x + y; 만 설정을 해 주어도 

```
   fi = (x, y) -> {
            int result = x + y;
            return result;
        };
```

와 같은 기능을 한다.





- 람다식에서 메소드의 매개 변수 또는 로컬 변수를 사용하면 이 두 변수는 final 특성을 가져야 한다.

- 매개 변수 또는 로컬 변수를 람다식에서 읽는 것은 허용되지만, 람다식 내부 또는 외부에서 변경할 수 없다.



ex)인터페이스

```
public interface MyFunctionalInterface {
    public void method();
}
```

ex) 로컬변수사용

```
public class UsingLocalVariable {
    void method(int  arg) {
        int localVar = 40;
 
        // arg = 31; // final 특성 때문에 수정 불가
        // localVar = 41; // final 특성 때문에 수정 불가
 
        MyFunctionalInterface fi = () -> {
            System.out.println("arg: " + arg);
            System.out.println("localVar: " + localVar);
        };
 
        fi.method();
    }
}

```

ex) 로컬변수사용main

```
public class UsingLocalVariableExam { 
    public static void main(String[] args) {
        UsingLocalVariable ulv = new UsingLocalVariable();
        ulv.method(20);
    } 
}

```

