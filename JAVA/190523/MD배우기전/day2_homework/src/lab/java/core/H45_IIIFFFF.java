package lab.java.core;

import java.util.Scanner;

public class H45_IIIFFFF {

	public static void main(String[] args) {
		
		
		Scanner num1 = new Scanner(System.in);
		
		System.out.println("배달해야되는 설탕의 KG를 입력하시오 (3 <= N <= 5000) : ");
		
		int score1 = num1.nextInt();
		
		int S5=0;
		int S3=0;
		
	
		if (score1%5==1||score1%5==4) {
			S5=(score1-(score1%10))/5;
			S3=((score1%10)/3);
		}
		else if (score1%5==3) {
			S5=score1/5;
			S3=1;
		}
		else	{
			S5=score1/5;
			S3=0;
		}
		
		System.out.println(score1%3!=0&&score1%5!=0?-1:(S5+S3)); 
	}

}
