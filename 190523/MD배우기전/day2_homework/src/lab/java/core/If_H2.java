package lab.java.core;

import java.util.Scanner;

public class If_H2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("점수를 입력하세요 (범위는 0~100) => ");
		
		int score = input.nextInt();
		
		if (score>89) System.out.println("A등급입니다.");
		else if (score>79) System.out.println("B등급입니다.");
		else if (score>69) System.out.println("C등급입니다.");
		else if (score>59) System.out.println("D등급입니다.");
		else System.out.println("F등급입니다.");
		
	}

}
