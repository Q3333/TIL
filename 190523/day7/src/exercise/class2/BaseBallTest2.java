package exercise.class2;

public class BaseBallTest2 {

	public static void main(String[] args) {
		BaseBall2 b = new BaseBall2();
		
			while(b.outCount!=3) {
			System.out.printf("******** %d번째 선수 출격 *********\n",(b.player+1));
			
			b.getStatus();
		}
	
	}

}