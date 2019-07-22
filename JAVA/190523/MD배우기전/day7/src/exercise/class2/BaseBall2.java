package exercise.class2;

public class BaseBall2 {
	public static int player = 0;
	public static int outCount = 0;
	public static int strike = 0;
	public static int ball = 0;
	
	public void getStatus() {
		
		// if(a>4)
		
		while(true) {
		System.out.print(" 공 던짐 => ");
		if(isStrike()) {
			System.out.println("스트라이크!!");
			System.out.printf("%d 아웃 , %d 스트라이크, %d 볼",outCount,++strike,ball);
			if(strike==3) {
				System.out.print(" ==> "+(++outCount)+"아웃");
				strike =0;
				ball =0;
				System.out.println();
				System.out.println("선수교체");
				++player;
				break;
			}
			System.out.println();
			System.out.println();
		}
		else {
			System.out.println("볼!!");
			System.out.printf("%d 아웃 , %d 스트라이크, %d 볼",outCount,strike,++ball);
			if(ball==4) {
				System.out.print(" ==> "+"1루 출루");
				strike =0;
				ball =0;
				System.out.println();
				System.out.println("선수교체");
				++player;
				break;
			}
			System.out.println();
			System.out.println();
		}
	}
}
	
	public boolean isStrike() {
		int rnum = (int)(Math.random()*2);
		//0,1만 나오는지 체크용 = OK 
		// System.out.println("rnum : "+rnum);
		if (rnum ==0) return true;
		else return false;
			
	}
	
}