package lab.java.core;

import java.util.Scanner;

public class While문연습 {

	public static void main(String[] args) {
		System.out.println("짝수, 홀수 변환기 (0을 입력시 종료)");
		Scanner s = new Scanner(System.in);
		int a;
		int odd = 0;
		int even = 0;
		
		do {
			a = s.nextInt();
			if (a%2==0&&a!=0)even++;
			else if (a%2==1&&a!=0)odd++;
		}
		while(a!=0);
		System.out.println("odd : "+odd);
		System.out.println("even : "+even);
	}

}
