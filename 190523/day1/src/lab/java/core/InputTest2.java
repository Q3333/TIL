package lab.java.core;

import java.util.Scanner;

public class InputTest2 {

	public static void main(String[] args) {
		System.out.print("태어난 년도를 입력하세요 : \n");
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();
		int age = 2019-year;
		System.out.println("Your age is "+ age);
		
		System.out.printf("나이는 %1d 살입니다.\n",age);
		
		
		
	}

}
