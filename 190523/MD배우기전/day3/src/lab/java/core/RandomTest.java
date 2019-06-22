package lab.java.core;

import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		//Math.random함수는 0<= N <1 을 리턴해줌(double타입)
		int rnum = (int)(Math.random()*100+1);//0제외라서 +1??
		
		Random r = new Random();
		int rnum2 = r.nextInt(100)+1;//0~99라서 +1을 해줌.
		
		System.out.println(rnum);
		System.out.println(rnum2);
	}

}
