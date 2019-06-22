package lab.java.core;

public class Operator {

	public static void main(String[] args) {
		// 논리연산자 &&,|| : 조건표현식 && 조건표현식
		System.out.println((3>4 || 'B'>'A'));
		//short circuit 연산자 라고도 함.
		//조건표현식1 && 조건표현식2의 경우 표현식 1이 false면 표현식2를 수행 안함. (이미 &&가 false라서,오류가 있어도 스킵)
		//조건표현식1 || 조건표현식2의 경우 표현식 1이 true면 표현식2를 수행 안함.
		String s = new String("java"); //객체 생성
		String st = null; // 객체 선언만 하고, 생성 안함
		System.out.println(st !=null && st.length()==0);
//		System.out.println(st ==null && st.length()==0);
		// 널포인트익셉션
	}

}
