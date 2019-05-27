package lab.java.core;

import java.util.Scanner;

public class Exe_16 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("평균 출력할 정수의 갯수를 입력하시오 : ");
		int a = s.nextInt();
		double abv = 0;
		
		for(int i=1;i<=a;i++) {
			System.out.println("평균 출력할 정수를 " + (a-(i-1)) +"개 입력하시오 ");
			int b = s.nextInt();
			abv = abv + b ; 
		}
		
		abv = abv/a;
		
		System.out.printf("평균 값 : %.2f",abv);
		

	}

}
