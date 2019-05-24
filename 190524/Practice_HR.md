# 인사관리 예제

## 인터페이스와 super를 사용해서 부모클래스의 toString을 받아오는 예제



### interface : employee.java

```java
package exercise.hr;

public interface employee {
	public void printC(); //abstract 가 자동으로 들어가있음.
	public void printT();
}
```

인터페이스 메소드인 printC와 printT를 인터페이스를 implements한 클래스에서 오버라이딩 하기 때문에 그냥 선언만 함.



### 부모클래스 국적 (employee 를 implement함)

```java
package exercise.hr;

public class Korea implements employee  {
	public void printC() {
		System.out.println(this.toString() + " 출근 ");
	}
	public void printT() {
		System.out.println(this.toString() + " 퇴근 ");
	}
	public String toString() {
		return "한국 "; // 미국, 일본 도 동일 
	}
}
```

Korea, America, Japan 클래스를 만들어서 employee를 implements함



### 자식클래스 사원 이름 (각 국적을 부모클래스로 받아서 상속한 클래스)

```java
package exercise.hr;

public class Kim extends Korea {
	public String toString() {
		return (super.toString()+ " : 김");
	}
}

```

Kim,Park,Mac,John,Danaka 5명의 자식클래스 예시를 만듬.



### HrTest.java(main 문이 들어감.)

```java
package exercise.hr;

public class HrTest {
	private static void showAll (employee e[]) {
		System.out.println("=========== 출근 시작 ============");
		for(employee num : e) {//employee인터페이스의 구현 클래스들을 인자로 전달할 경우 
			num.printC();	 //자동으로 Upcasting이 되고, Downcasting 할 수 있습니다.
			}
		System.out.println();
		
		System.out.println("=========== 퇴근 시작 ============");
		for(employee num : e) { 
			num.printT();	
			}
		System.out.println();
	
	}
	
	private static void summary (employee e[]) {
		
		int kor = 0;
		int ame = 0;
		int jpr = 0;
		
		System.out.println("=========== 회사 사원 목록 ============");
		for(employee num : e) {
			System.out.println(num.toString());
			if(num instanceof Korea) {
				kor++;
			}
			else if (num instanceof America) {
				ame++;
			}
			else if (num instanceof Japan) {
				jpr++;
			}
		}
		
		System.out.println();
				
		System.out.println("=========== 국적 별 사원 수 ============");
		System.out.println("## 한국인 수 : "+kor);
		System.out.println("## 미국인 수 : "+ame);
		System.out.println("## 일본인 수 : "+jpr);
	
	}

	public static void main (String[] args) {
		
		employee ins[] = new employee[] {
			new Kim(),
			new Park(),
			new Mac(),
			new John(),
			new Danaka()
		};
		
		showAll(ins);
		summary(ins);

						
	}// main end;
}// class end

```



