package lab.java.core;

import java.util.Scanner;

public class C_H3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int big =0;
		int small =0;
			
		System.out.println("정수 두개를 입력하세요.");
		int a = s.nextInt();
		int b = s.nextInt();
			
		if (a>b&&a!=b) {big=a;small=b;}
		else if (a<b&&a!=b) {big=b;small=a;}
		else System.out.println("두 값이 같습니다.");
		
		int count = big-small;
		
		for(int i=0;i<=count;i++) {
			System.out.print(small++ +" ");
		}
		
		
		
		/* 샘 코딩
		 * 
		 * if (start>end) {
		 * 			int temp = start;
		 * 			start = end;
		 * 			end = temp;
		 * }
		 * for int i=start;i<end+1;i++){
		 * 		System.out.print(i+" ")
		 * }
		 * 
		 * 
		 */
	}

}

//10,11,13풀기