package lab.java.core;

import java.util.Scanner;

public class IfSwitch {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("한 문자만 입력하세요 => ");
		
		String st = input.next();
		char ch = st.charAt(0); //중요 @@@@@ ch로 받음, 0이 첫글자
				
		if(ch>47 && ch<58) {
			System.out.println(st+"는 숫자입니다.");
							}
		else if(ch>64 && ch<91){
			System.out.println(st+"는 영어 대문자입니다.");
								}
		else if(ch>96 && ch<123){
			System.out.println(st+"는 영어 소문자입니다.");
								}
		else {
			System.out.println("ㅁㅁㄴㅁㄴㅁ");
			}
		
		
		

	}

}
