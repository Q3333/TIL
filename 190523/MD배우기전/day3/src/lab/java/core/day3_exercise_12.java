package lab.java.core;

import java.util.Scanner;

public class day3_exercise_12 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		int temp = 0;
		
		System.out.println("두개의 정수를 입력하시오 (100이하)");
		int start = s.nextInt();
		int end = s.nextInt();
		
		
		if(end<start) {
			temp = end;
			end = start;
			start = temp;
		}
		
		for(int i=start;i<=end;i++) {
			System.out.print(i+" ");
		}
		
		
	}

}
