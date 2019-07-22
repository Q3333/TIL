package lab.java.core;

import java.util.Scanner;

public class H55 {

	public static void main(String[] args) {
		
		
		Scanner num1 = new Scanner(System.in);
		
		System.out.println("민수의 키와 몸무게를 입력하시오 (띄어쓰기로 구분) : ");
		
		int score1 = num1.nextInt();
		int score2 = num1.nextInt();
		
		System.out.println("가영이의 키와 몸무게를 입력하시오 (띄어쓰기로 구분) : ");
		
		int score3 = num1.nextInt();
		int score4 = num1.nextInt();
		
		System.out.println(score1>score3&&score2>score4);
		
		
	}

}
