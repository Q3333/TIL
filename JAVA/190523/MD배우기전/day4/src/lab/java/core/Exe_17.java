package lab.java.core;

import java.util.Scanner;

public class Exe_17 {

	public static void main(String[] args) {
		Scanner s =  new Scanner(System.in);
		
		System.out.println("한 개의 자연수를 입력하시오");
		int a = s.nextInt();
		
		for(int i=1; i<=10; i++) {
			System.out.print(a*i+" ");;
		}
		
	}

}
