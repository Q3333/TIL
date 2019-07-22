package lab.java.core;

public class StaticTest {
	public static int snum =5; //1번 수행 변수 초기화
	static {				// Static Initialize Block, 다른 것 보다 무조건 우선수행
		snum  +=5; 			//  2번 수행               (main 보다 먼저 수행)
	}
	
	public static void main(String[] args) {
		System.out.println(snum);// 4번으로 수행
		snum /=4;  //5번으로 수행
		System.out.println(snum);// 6번으로 수행

	}

	static { //메모리에 초기화해야할 코드 수행(예 : 라이브러리 로딩,특정 개체에 대한 초기화 작업)
		snum  *=5;
	}//3번으로 수행
	
}
