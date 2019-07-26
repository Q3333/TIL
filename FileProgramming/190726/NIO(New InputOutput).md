



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





## Buffer NIO

- NIO 에서는 데이터를 입출력하기 위해 항상 버퍼를 사용해야 한다.

- 버퍼는 읽고 쓰기가 가능한 **메모리 배열**이다.
- CharBuffer, IntBuffer, DoubleBuffer, ShortBuffer, LongBuffer, FloatBuffer, ByteBuffer 등의 종류가 있음



큰 분류로 다이렉트(Direct)와 넌다이렉트(NonDirect)로 분류하기도 한다.

![1564104618052](<https://github.com/Q3333/ITL/blob/master/FileProgramming/190726/images/NIO2.PNG>)



- 다이렉트 버퍼는 자주 생성하기 보다는 한 번 생성해 놓고 재사용하는 것이 적합 
- 다이렉트 버퍼는 운영체제가 관리하는 메모리를 사용하므로 운영체제가 허용하는 범위 내에서 대용량 버퍼를 생성시킬 수 있다
- 넌다이렉트 버퍼는 입출력을 하기 위해 임시 다이렉트 버퍼를 생성 -> 넌 다이렉트 버퍼에 있는 내용을 임시 다이렉트 버퍼에 복사 -> 임시 다이렉트 버퍼를 사용해서 운영체제의 native I/O 기능을 수행
- 다이렉트 버퍼는 채널(Channel)을 사용
- 버퍼의 데이터를 읽고 저장할 경우에만 운영체제의 native I/O를 수행
- 채널을 사용하지 않고 ByteBuffer 의 get() / put() 메소드를 사용해서 버퍼의 데이터를 읽고 저장한다면 내부적으로 JNI를 호출해서 native I/O를 수행,  JNI 호출이라는 오버 헤더가 추가된다





버퍼 성능 비교 코드

```java
package NIO;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;

public class Buffer {
	 public static void main(String[] args) throws Exception {
	        Path from = Paths.get("C:/r_temp/E1.png");
	        Path to1 = Paths.get("C:/r_temp/E2.png");
	        Path to2 = Paths.get("C:/r_temp/E3.png"); 
	        long size = Files.size(from); 
	        FileChannel fileChannel_from = FileChannel.open(from);
	        FileChannel fileChannel_to1 = FileChannel.open(to1,
	                EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE));
	        FileChannel fileChannel_to2 = FileChannel.open(to2,
	                EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE)); 
	        ByteBuffer nonDirectBuffer = ByteBuffer.allocate((int) size);
	        ByteBuffer directBuffer = ByteBuffer.allocateDirect((int) size); 
	        long start, end; 
	        start = System.nanoTime(); 
	        for (int i = 0; i < 100; i++) {
	            fileChannel_from.read(nonDirectBuffer);
	            nonDirectBuffer.flip();
	            fileChannel_to1.write(nonDirectBuffer);
	            nonDirectBuffer.clear();
	        } 
	        end = System.nanoTime(); 
	        System.out.println("넌 다이렉트: \t:" + (end - start) + " ns");

	        start = System.nanoTime();
	        
	        for(int i=0; i<100; i++) {
	        	fileChannel_from.read(directBuffer);
	        	directBuffer.flip();
	        	fileChannel_to2.write(directBuffer);
	        	directBuffer.clear();
	        }
	        
	        end = System.nanoTime();
	        System.out.println("다이렉트: \t:" + (end - start) + " ns");
	        
	        fileChannel_from.close();
	        fileChannel_to1.close();
	        fileChannel_to2.close();
}
}
```





![1564104618052](<https://github.com/Q3333/ITL/blob/master/FileProgramming/190726/images/NIO3.PNG>)





### 바이트 해석 순서

- 데이터를 처리할 때 바이트 처리 순서는 운영체제마다 차이가 있다

- 앞쪽 바이트부터 먼저 처리하는 것을 **Big endian**,  뒤쪽 바이트부터 먼저 처리하는 것은 **Little endian**

- ByteOrder.natvieOrder( ) – 현재 동작하고 있는 운영체제가 Big endian인지 Little endian인지 알려준다.

- JRE가 설치된 어떤 환경이든 JVM은 무조건 Big endian 으로 동작

- 운영체제와 JVM의 바이트 해석 순서가 다를 경우 JVM이 운영체제와 데이터를 교환할 때 자동적으로 처리

- 다이렉트 버퍼일 경우 운영체제의 native I/O를 사용하므로 운영체제의 기본 해석순서로 JVM의 해석 순서를 맞추는 것이 성능에 도움이 된다.

  

