package lab.java.core;

import java.util.Scanner;

public class If_H1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("정수를 입력하세요 => ");
		
		int num = input.nextInt();
		
		if (num%2==0) System.out.println("짝수입니다.");
		
		else System.out.println("홀수입니다.");
		
		
	}

}
