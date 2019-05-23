package lab.java.core;

import java.util.Scanner;

public class H22 {

	public static void main(String[] args) {

		Scanner num1 = new Scanner(System.in);
		
		System.out.println("나눗셈을 할 정수를 두개 입력하시오 (띄어쓰기로 구분) : ");
		
		int score1 = num1.nextInt();
		int score2 = num1.nextInt();
		
		System.out.println(score1 + " / " + score2 + " = " + (score1/score2) + "..." + (score1%score2) );
		
	}

}
