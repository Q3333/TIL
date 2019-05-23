package lab.java.core;

import java.util.Scanner;

public class Sw_H3 {
	// 대소문자 구별 없이 영어문자 하나 입력받아서 영문자로 시작하는 단어 출력,
	// A,B,C만 처리하고 "나머지 문자는 준비중입니다." 라고 출력합니다.

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("영어 문자 하나를 입력하세요(대소문자 구별없음) => ");
		
		String st = input.next();
		char ch = st.charAt(0);
		
	
		
		/* 숫자로바꿈
		switch ((int)ch-64) { //97
		case 33:
		case 1:
			System.out.println("apple"); break; 
		case 34:
		case 2:
			System.out.println("blue"); break;
		case 35:
		case 3:
			System.out.println("cat"); break;
		default:
			System.out.println("아직 준비중입니다.");
		}
		*/
		
		switch (st) { 
		case "A":
		case "a":
			System.out.println("apple"); break; 
		case "b":
		case "B":
			System.out.println("blue"); break;
		case "C":
		case "c":
			System.out.println("cat"); break;
		default:
			System.out.println("아직 준비중입니다.");
		}
		//// case "a"로 바꿔보기
		
		
	}

}
