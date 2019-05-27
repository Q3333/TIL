package lab.java.core;

public class ²ôÀû²ôÀû {
	public static void main(String[] args) {
		
		int k =1;
		int [] score = new int[5];
		
		score[0]=50;
		score[1]=60;
		score[k+1]=70;
		score[3]=80;
		score[4]=90;
		
		int tmp = score[k+2] + score[4];
		
		for(int i=0;i<score.length;i++) {
			System.out.printf("score[%d] : %d\n",i,score[i]);
			//tmp += score[i];
		}
		
		System.out.println("tmp : "+tmp);
		
	}

}
