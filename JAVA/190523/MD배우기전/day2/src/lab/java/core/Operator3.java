package lab.java.core;

import java.util.Scanner;

public class Operator3 {

	public static void main(String[] args) {
		// 삼항연산자 (조건표현식이 true이냐 false이냐에 따라 수행하는 표현식 2개가 옴.)
		// 조건 표현식?표현식1(true시):표현식2(false시)
		// 정수를 입력받아서 짝수인지 홀수인지 출력하는 Ex)
		
		Scanner input = new Scanner(System.in);
		System.out.println("정수 입력 하세요 => ");
		int num = input.nextInt();
		System.out.println(num %2==0?"짝수":"홀수"); 
		
		double result = 3>4?99.9:90;
		//연산식 내에서 자동으로 큰 타입으로 형변환 promotion이 일어납니다. (표현식 순서 상관 ㄴ)
		
		int result2 = (int)(3>4?99.9:90); // 굳이 int로 저장한다고 할 경우
		
	}

}
