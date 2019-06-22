package com.lg.workshop1.one;

import java.util.Scanner;

public class PrimeNumber {
	public static int getUserInput() {
		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}

	public static void main(String[] args) {
		int loop;
	
		for(;;) {
			//A1:
			
			int i=1;
			System.out.println("숫자를 입력하세요 (종료 :0) :");
			loop = getUserInput();
			if(loop==0) {
				System.out.println("Bye~~");
				break;
			}
			
			do {
				if(loop==1){
					System.out.println(loop+"은 소수가 아닙니다.");
					break;
				}
				else if(loop==2){
					System.out.println(loop+"은 소수입니다.");
					break;
				}
				
				int cal;
				cal = loop % (1+i); // i를 2로 하면?
				
				if (cal==0) {
					System.out.println(loop+"은 소수가 아닙니다.");
					break ;
				//	break A1;
				}
				else if(i==loop-2) System.out.println(loop+"은 소수입니다.");
				i++;
				
			}
			while(i<loop-1);
		} // for문 엔드
			
//			Scanner s = new Scanner(System.in);
//			loop = s.nextInt(); //getUserInput으로뺴버림
			
			
//			for(int i=1;i<(loop-1);i++) {
//				int cal;
//				cal = loop % (1+i); // loop i가문제
//				if (cal==0) {
//					System.out.println(loop+"은 소수가 아닙니다.");
//					break ;
//				//	break A1;
//				}
//				else if(loop==1)System.out.println(loop+"은 소수가 아닙니다.");
//				else if(i==loop-2)System.out.println(loop+"은 소수입니다.");
//			}
			
							
		
	}//main end

}//class end
