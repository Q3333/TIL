package lab.java.core;

public class DataType1 {
	
	public static void main(String[] args) {
		boolean success = false;//정수와 호환 불가, 키워드 false 또는 true만 할당가능
		//메모리는 1byte할당
		System.out.println(success);
		//success = 1;
		
		byte num1 = 127;
		/*byte = 정수 지료형, 1byte 할당 sign bit를 제외한 7bit의 binary로 저장 
			     1 or 0 -2^7 ~ 2^7 -1(0이포함되어있으므로 1제거) -128~127 */
		System.out.println(num1);
		//num1 = 128; 유효범위 초과
		
		short num2 = 32767;
		//short = 정수자료형, 2byte 할당 -2^15~2^15-1, -32768~32767
		System.out.println(num2);
		//num2 = 32768; 유효범위 초과
		
		int num3 = 2147483647;
		//int = 정수자료형, 4byte 할당, -2^31~2^31-1, -2147483648 ~ 2147473647
		System.out.println(num3);
		//num3 = 2147483648; 유효범위초과
		
		num3 = 077; // 8진수
		System.out.println(num3);//출력은 decimal 10진수로됨
		num3 = 0xff; // 16진수
		System.out.println(num3);//출력은 10진수
		
		
		
		long num4 = 2147483648L; 
		// 4바이트가 디폴트라서 8바이트로만드는게 뒤에 대,소문자 L 을 붙여야함,L은출력안됨)
		// long = 정수자료형, 8byte 할당, -2^63 ~ 2^63-1
		System.out.println(num4);
		
		
		
		
		///char 문자자료형, 자바는 unicode 지원, 2byte할당, 0~2^16-1, 0~65535
		char ch1 = 'A';
		System.out.println(ch1);
		ch1 = 97; //ascii 코드 값
		System.out.println(ch1);
		ch1 = '\u0063'; //unicode 값 (유니코드의서브로 아스키가 포함되어있음)
		System.out.println(ch1);
		
		
		
		//실수 자료형, 바이너리가 아닌 부동소수점 형식으로 저장 (가수부,지수부), 4byte할당
		float num5 = 3.14F; // default 실수 literal 유형은 double(8byte)
							// 뒤에 F,f를 붙여주면 8->4바이트가됨.
		System.out.println(num5);
		double num6 = 3.14;
		System.out.println(num6);
		num6 = 1.204307E-5;// IEEE표기형식, 과학적 수치 표기형식
		System.out.println(num6);
		num6 = 1.204307E+9;
		System.out.println(num6);
		
		
		//문자열은 Reference Data Type 객체자료유형
		//*String은 객체임.
		String st = new String("JAVA"); //st는 객체명, new를 통해 String이라는 메모리에 st라는 객체를 생성.
		// new를 사용시 힙에 데이터를 생성해줌.
		System.out.println(st);
		System.out.println(st.length());
		
		String st2 = "jjjava"; // 직접 넣어줘도 st2는 객체임
		// heap메모리가 아니라 String 상수 pool 메모리 영역에 생성.
		System.out.println(st2);
		
		final int PORT = 9000;
		System.out.println(PORT);
		//PORT = 5555; 상수라서 값 변경이 불가능함.
		
		
		
	}

}
