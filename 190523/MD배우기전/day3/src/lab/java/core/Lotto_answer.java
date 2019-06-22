package lab.java.core;

public class Lotto_answer {
	
	public static void main(String[] args) {
		int[] lotto = new int[6];//로또 번호 저장할 배열방 준비
		for(int i=0; i<lotto.length;i++){
			lotto[i] = (int)(Math.random()*45+1);
			for(int j=0;j<i;j++) {
				if(lotto[i]==lotto[j]) {
					i--; // 난수 다시 발급 받는 과정 J가 아니라 I임!
					break;
				}
			}
		}
			for(int num : lotto) {
				System.out.print(num+" ");
			}
			
		}
	}


