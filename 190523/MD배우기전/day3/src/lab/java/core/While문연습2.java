package lab.java.core;

import java.util.Scanner;

public class While¹®¿¬½À2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int base, height;
		char c;
		
		do {
			System.out.println("base : ");
			base = s.nextInt();
			System.out.println("height : ");
			height = s.nextInt();
			System.out.println("Triangle width : "+Math.round(base*height)*50/100.0);
			
			System.out.println("Continue? (Y,y)");
			c = s.next().charAt(0);
		}
		while(c=='Y'||c=='y');
		System.out.println("end");
		

}// main end
}//class end
