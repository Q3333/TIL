package lab.java.core;

import java.util.Scanner;

public class If_H3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("년도를 입력하세요  => ");
		
		int year = input.nextInt();
		
		if (year%4==0) 								{
			if (year%400==0)System.out.println("윤년입니다.");
			else if (year%100==0)System.out.println("평년입니다.");
			else System.out.println("윤년입니다.");		 }
		else System.out.println("평년입니다.");

		
	}

}
