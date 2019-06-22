package lab.java.core;

import java.util.Random;

public class AryAry_H1_이중배열_같은값찾기 {
	public static void main(String[] args) {
		int ar1[][] = new int[3][4];
		int ar2[][] = new int[3][4];
		
		/*
		Random r = new Random();
		int rnum = r.nextInt(12)+1;
		*/
		
		int a = (int)(Math.random()*12+1);
		int count =0;
		
		System.out.println("첫번째 배열");
		for(int i=0 ; i<(ar1.length);i++) {
			for(int j=0; j<(ar1[0].length);j++) {
				ar1[i][j]=(int)(Math.random()*12+1);
				//System.out.print(ar1[i][j]+" ");
				System.out.printf("%2d ",ar1[i][j]);
			}
			System.out.println();
		}
		System.out.println("두번째 배열");
		for(int i=0 ; i<(ar2.length);i++) {
			for(int j=0; j<(ar2[0].length);j++) {
				ar2[i][j]=(int)(Math.random()*12+1);
				//System.out.print(ar2[i][j]+" ");
				System.out.printf("%2d ",ar2[i][j]);
			}
			System.out.println();
		}
		
		
		//// 배열 2개 생성 후 난수 집어넣음.
		
		for(int i=0 ; i<(ar2.length);i++) {
			for(int j=0; j<(ar2[0].length);j++) {
				if(ar1[i][j]==ar2[i][j]) {
					count++;
					System.out.printf("[%d][%d]가 같은 값 %d를 보유중 \n",i,j,ar1[i][j]);
				}// if
					
			}// 안 for
			
		} //바깥 for
		
		System.out.println("같은 값을 가진 요소의 갯수 : "+count);
		
	}//main end
}//class end
