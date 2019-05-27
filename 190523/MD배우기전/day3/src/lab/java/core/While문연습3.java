package lab.java.core;

import java.util.Scanner;

public class While¹®¿¬½À3 {

	public static void main(String[] args) {
		int odd =0;
		int even =0;
		int num;
		Scanner s = new Scanner(System.in);
		
		do {
			num = s.nextInt();
			if(num%2==0)even++;
			else odd++;
			
		}
			while(num!=0);
		System.out.println("odd : " + odd);
		System.out.println("even : " + even);
		
}// main end
}//class end
