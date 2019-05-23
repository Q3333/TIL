package lab.java.core;

import java.util.Random;

public class AryAry_H3_1차원배열_오름차순 {
	public static void main(String[] args) {
	
		int[] array = new int[10];
		
		for(int r = 0;r < array.length;r++) {
			array[r] = (int)(Math.random()*100+1);
		}
		
		//오름차아아아아아사수ㅜㅅ으으우운
		
		int len = array.length;
		int count =0;
		
		System.out.println("정렬 전");	
		for(int r = 0; r< array.length;r++) {
			System.out.print(array[r]+" ");
		}
			
		System.out.println();
		
		for (int i=0; i<len; i++) {
			int max =0;
			for (int j=0;j<(len-i);j++) {
				if(array[j]>max) {
					max=array[j];
					count = j;//max값의 순서 j를 기록해놓기 위함.
				}
			}
			max = array[len-i-1];//i가 돌아갈 수록 맨 뒤에서 왼쪽으로 한칸씩
			array[len-i-1]=array[count];
			array[count] = max;
			//맨 뒷자리랑 자리바꾸기.
			
		}
		
		
		System.out.println("정렬 후");
		for(int r = 0; r< array.length;r++) {
			System.out.print(array[r]+" ");
		}
			
		
	}//main end
}//class end
