



콘솔 생성 메소드 :  System.console();

이클립스에서는 콘솔 싱행이 안되므로 CMD에서 실행시켜야 한다.

```java
//여기 아래부터 복사해서 CMD에서 실행시켜야함.
import java.io.Console;

public class UsingConsoleReader {

	public static void main(String[] args) {
		  Console console = null;
		  String inputName = null;
		char[] inputPasswd = null;
		  try  {
		     //  콘솔 객체 생성
		     console = System.console();
		     // if console is not null
		     System.out.println(console);
		     if (console != null)     {
		        // 사용자로부터 이름 입력 받음
		        inputName = console.readLine("Name: ");
		        System.out.println("Name entered : " + inputName);
		        
		        inputPasswd = console.readPassword("Password : ");
		        // prints
		        System.out.println("Name entered : " + inputPasswd);
		     }
		  } catch (Exception ex)  {
		     ex.printStackTrace();
		  }


	}

}

```





## **NIO(New Input/Output)**

- 자바 4부터 새로운 입출력(NIO: New Input/Output)이라는 뜻에서 java.nio 패키지가 포함

- 자바 7에서  자바 IO와 자바 NIO 사이의 일관성 없는 클래스 설계를 바로 잡고, 비동기 채널 등의 네트워크 지원을 대폭 강화한 NIO.2 API가 추가

- NIO.2는 기존 java.nio의 하위 패키지(java.nio.channels, java.nio.charset, java.nio.file)에 통합





- IO와 NIO의 차이
  - 데이터를 입출력한다는 목적은 동일하지만, 수행방식의 차이가 큼



![1564104618052](<https://github.com/Q3333/ITL/blob/master/FileProgramming/190726/images/NIO1.PNG>)





NIO는 멀티채널을 제공한다 ( 멀티채널은 빅데이터 처리를 도와줌 )