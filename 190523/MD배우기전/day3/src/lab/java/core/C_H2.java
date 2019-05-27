package lab.java.core;

import java.util.Scanner;

public class C_H2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		
		for(int i=1;i<2;i++) {
			System.out.print("Base = ");
			int base = s.nextInt();
			System.out.print("Height = ");
			int height = s.nextInt();
			System.out.println("Triangle width = " + Math.round(base*height*100)/200.0);//선생님답
			// Math.round둘째자리 100.0 셋째자리 1000.0 곱하고 나누기.
			System.out.println("continue?(Y,y일경우 반복,아닐경우 그만)");
			String st = s.next();
			char con = st.charAt(0); 
			////char con = s.next().charAt(0); 한줄 선언도 됨 
			if(con=='Y'||con=='y')i--;
		}

	}

}

//10,11,13풀기