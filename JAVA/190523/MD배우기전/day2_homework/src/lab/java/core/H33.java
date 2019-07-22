package lab.java.core;

import java.util.Scanner;

public class H33 {

	public static void main(String[] args) {
		
		
		Scanner num1 = new Scanner(System.in);
		
		System.out.println("직사각형의 가로와 세로의 길이를 입력하시오 (띄어쓰기로 구분) : ");
		
		int score1 = num1.nextInt();
		int score2 = num1.nextInt();
		
		score1 = score1 +5;
		score2 = score2 *2;
		
		System.out.println("width : = " + score1);
		System.out.println("length : = " + score2);
		System.out.println("area : = " + (score1*score2));
		
	}

}
