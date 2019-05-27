package lab.java.core;

public class Array1 {

	public static void main(String[] args) {
		// 배열 생성방법 1번째
		int[] score = new int[5];// 선언 , []의 위치는 어디든 상관없으나 타입 뒤로 하는게 좋음
		// 기본으로 디폴트 0 값이 들어감
		char ch;
		
		System.out.println("배열의 사이즈 = "+score.length);
		
		for(int i=0;i<score.length;i++) {
			System.out.println("score["+i+"]="+score[i]);
		}
		
		// 배열 생성방법 2번째
		int[] score2 = new int[] {100,300,500,700,900,901,902};
		// 생성을 하면서 명시적 초기화를 실행.
		
		System.out.println("배열의 사이즈 = "+score2.length);
		for(int num : score2) { // 배열 객체에서 순차적으로 하나씩 요소를 꺼내옴
			System.out.println(num);
		}
		
		
		//배열 생성방법 3번째
		int[] score3 = {100,300,500};
		for(int num : score3) { 
			System.out.println(num);
		}
	}

}
