package lab.java.core;

import java.util.Scanner;

public class Sw_H2 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("점수를 입력하세요 (범위는 0~100) => ");
		
		int score = input.nextInt();
		
		switch (score/10) {
			case 10 : 
			case 9 : System.out.println(score+"점은 A등급입니다."); break;
			case 8 : System.out.println(score+"점은 B등급입니다."); break;
			case 7 : System.out.println(score+"점은 C등급입니다."); break;
			case 6 : System.out.println(score+"점은 D등급입니다."); break;
			default : System.out.println(score+"점은 F등급입니다."); 
	}

}
}
