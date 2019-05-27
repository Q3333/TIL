package lab.java.core;

import java.util.Random;
import java.util.Scanner;

public class R_H1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int rnum = r.nextInt(100)+1;//0~99라서 +1을 해줌.
		int chance = 0;
		
		
		do {
			System.out.println("1~100까지의 답을 맞춰보세요(기회 5번, "+(chance+1)+"번째 시도) :");
			int ans = s.nextInt();
			
			if(ans>rnum)System.out.println("Down");
			else if(ans<rnum)System.out.println("Up");
			else {System.out.println("You Win!!!"); break;}
			chance++;
			
		}
		while(chance!=5);
		if(chance==5)System.out.println("I(Computer) Win^^");
	

	}

}

/*
UpDown게임
난수를 생성해주는 Math.random() 또는 java.util.Random클래스를 사용해서 1~100사이의 난수를 생성하고 이수는 컴퓨터가 생각한 수로 저장합니다.
사용자로부터 1~100사이의 정수를 입력받아서 사용자가 입력한 정수가 컴퓨터가 저장하고 있는 난수와 동일하면  “You Win!!!”이라고 출력하고, 
사용자가 입력한 정수가 컴퓨터가 저장하고 있는 난수보다 크면 “Down”이라고 출력합니다.
사용자가 입력한 정수가 컴퓨터가 저장하고 있는 난수보다 작으면 “Up”이라고 출력합니다.
사용자에게 5번의 기회를 제공한 후에도 맞추지 못하면 “I(Computer) Win^^”이라고 출력합니다.
 */

