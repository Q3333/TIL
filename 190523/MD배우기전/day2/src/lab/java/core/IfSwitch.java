package lab.java.core;

import java.util.Scanner;

public class IfSwitch {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("廃 庚切幻 脊径馬室推 => ");
		
		String st = input.next();
		char ch = st.charAt(0); //掻推 @@@@@ ch稽 閤製, 0戚 湛越切
				
		if(ch>47 && ch<58) {
			System.out.println(st+"澗 収切脊艦陥.");
							}
		else if(ch>64 && ch<91){
			System.out.println(st+"澗 慎嬢 企庚切脊艦陥.");
								}
		else if(ch>96 && ch<123){
			System.out.println(st+"澗 慎嬢 社庚切脊艦陥.");
								}
		else {
			System.out.println("けけいけいけ");
			}
		
		
		

	}

}
