package exercise.class2;

public class BaseBallTest {

	public static void main(String[] args) {
//		
		BaseBall a = new BaseBall();
		
		for(;;) {
			if(a.outCount==3) {
				System.out.println("쓰리아웃! 공수교체!!");
				break;
			}
			
			System.out.printf("*********%d번째 선수 출격********\n",(a.player+1));
			System.out.println();
			for(;;) {	
				System.out.print(" 공 던짐 => ");
				if(a.isStrike()) {
					System.out.print("스트라이크!!\n");
					a.strike++;
				}
				else {
					System.out.print("볼!!\n");
					a.ball++;
				} // else end
					
				a.getStatus();
				
				
				if(a.strike==3) {
					System.out.print(" ==> "+(++a.outCount)+"아웃");
					a.strike =0;
					a.ball =0;
					System.out.println();
					System.out.println("선수교체");
					System.out.println();
					++a.player;
					break;
				}
					
				
				if(a.ball==4) {
					System.out.print(" ==> "+"1루 출루");
					a.strike =0;
					a.ball =0;
					System.out.println();
					System.out.println("선수교체");
					System.out.println();
					++a.player;
					break;
					}
				System.out.println();
				
			}//안쪽 for문 엔드
			
		
		}//바깥 for문 엔드
					
		
	}// main end
	
	} // class end


