package exercise.class2;

import java.util.Random;

public class BaseBall {
	public static int player = 0;
	public static int outCount = 0;
	public static int strike = 0;
	public static int ball = 0;
	
	public static void getStatus() {
//		if(strike == 3) {
//			System.out.printf("%d 아웃 , %d 스트라이크, %d 볼 ==> %d아웃",outCount,strike,ball,(1+(outCount++)));
//		}
		System.out.printf("%d 아웃 , %d 스트라이크, %d 볼 ",outCount,strike,ball);
		
	
	}
	
	public static boolean isStrike() {
		int rnum = (int)(Math.random()*2);
		//0,1만 나오는지 체크용 = OK 
		// System.out.println("rnum : "+rnum);
		if (rnum ==0) return true;
		else return false;
			
		
		
	}
	
}
