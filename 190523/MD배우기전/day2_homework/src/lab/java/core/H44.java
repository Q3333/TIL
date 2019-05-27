package lab.java.core;

import java.util.Scanner;

public class H44 {

	public static void main(String[] args) {
		
		
		Scanner num1 = new Scanner(System.in);
		
		System.out.println("배달해야되는 설탕의 KG를 입력하시오 (3 <= N <= 5000) : ");
		
		int score1 = num1.nextInt();
		
		int S5;
		int S3;
		
		
		/*int test = score1%5;
		 * 
		int S5 = test*score1/5; //5봉지
		int S3 = (score1-(S5*5)) / 3; 
		int S1 = */
		
		//System.out.println(score1%3!=0&&score1%5!=0?-1:(S5+S3)); 
		
		//System.out.println("가져가야하는 봉지의 수는 " + score1);
	
		if (score1%5==0) S5=score1/5;
		
		
		
		//System.out.println(score1%3!=0&&score1%5!=0?-1:(S5+S3)); 
		
	}

}
