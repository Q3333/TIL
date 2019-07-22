package lab.java.core;

import java.util.Scanner;

public class Sw_H1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("정수를 입력하세요 => ");
		
		int num = input.nextInt();
		
		switch (num%2) { 
		case 0:
			System.out.println(num+"은 짝수입니다."); break; 
		case 1:
			System.out.println(num+"은 홀수입니다.");
		}
		
	}

}
