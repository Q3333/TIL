package lab.java.core;

import java.util.Scanner;

public class H11 {
	
	public static void main(String[] args) {


	Scanner num1 = new Scanner(System.in);
		
	/*
		System.out.println("국어 과목의 점수를 입력하시오 => ");
		int score1 = num1.nextInt();
		System.out.println("영어 과목의 점수를 입력하시오 => ");
		int score2 = num1.nextInt();
		System.out.println("수학 과목의 점수를 입력하시오 => ");
		int score3 = num1.nextInt();
		System.out.println("컴퓨터 과목의 점수를 입력하시오 => ");
		int score4 = num1.nextInt();
		*/
	
		System.out.println("국어, 영어, 수학, 컴퓨터 과목의 점수를 입력하시오(띄어쓰기로 구분) => ");
		int score1 = num1.nextInt();
		int score2 = num1.nextInt();
		int score3 = num1.nextInt();
		int score4 = num1.nextInt();
		
		
		System.out.println("Sum : "+(score1+score2+score3+score4));
		System.out.println("Avg : "+(score1+score2+score3+score4)/4);
	
		
		

}
	
}
