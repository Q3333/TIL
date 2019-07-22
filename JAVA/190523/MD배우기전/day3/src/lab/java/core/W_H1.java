package lab.java.core;

import java.util.Scanner;

public class W_H1 {

	public static void main(String[] args) {
		
		int num = 1;
		int count = 0;
		Scanner input = new Scanner(System.in);
		
		while(num!=0) {
		//System.out.println("정수를 입력하세요 (0을 입력시 종료)");
		num = input.nextInt();
		if(num%3!=0&&num%5!=0)count++;
		}
		
		System.out.println("3과 5의 배수를 제외한 수들의 개수 : "+count);
		
		
		/*선생님 답
		 * int count =0;
		 * Scanner input = new Scanner(System.in);
		 * while(true){
		 * int num = input.nextInt();
		 * if(num==0) break;
		 * if((num%3==1||num%3==2)&&num%5!=0){
		 * 			count++;
		 * }	 * 
		 * 
		 * } // while end
		 * System.out.println("3과 5의 배수를 제외한 수들의 개수 : "+count");
		 */
		
	}

}
