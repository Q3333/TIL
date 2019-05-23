package lab.java.core;

import java.util.Random;

public class Lotto {

	public static void main(String[] args) {
		int[] lotto = new int[6]; // 로또 번호 저장할 배열방 준비
		//1~45 범위에서 난수 생성해서 배열 첫번째 방에 저장
		//1~45 범위에서 난수 생성해서 첫번째 방에 저장된 수와 다를 경우에만 두번째 방에 저장
		Random r = new Random();
	
		for(int i=0;i<6;i++) {
			lotto[i] = r.nextInt(45)+1; 
				for(int b=i;b>0;b--) {
					if(lotto[i]==lotto[b-1]) {
						lotto[i] = r.nextInt(45)+1;
					}//안쪽 for문 엔드
				}//바깥 for문엔드
			System.out.print(lotto[i]+" ");
		}//바깥쪽 if문 엔드
			
			
	
	
	}// main end
	}//class end


