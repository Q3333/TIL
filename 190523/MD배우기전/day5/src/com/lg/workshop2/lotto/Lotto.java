package com.lg.workshop2.lotto;

import java.util.Random;

public class Lotto {
	public final static int LOTTO_NUM_CNT =6;

public int[] generateLottoNumbers() {
	int[] arr = new int[LOTTO_NUM_CNT];
	for(int i=0;i<arr.length;i++) {
		arr[i] = getRandomNumber();
		for(int j=0;j<i;j++) {
			if(arr[i]==arr[j]) {
				i-=1;
				break;
			}
		}
	}
	return arr;
}

public void displayLottoNumbers(int[] lottoNumbers) {
	System.out.println("<< Lotto >> ");
	for(int i=0;i<lottoNumbers.length;i++)
	{
		System.out.print(lottoNumbers[i]+" ");
	}
	
}
	
public void sortLottoNumbers(int[] lottoNumbers) {
	
//	
	int count = 0;
	
	int len =lottoNumbers.length;
	
	for(int i=0;i<len;i++) {
		int max = 0;
		for(int j=0;j<len-i;j++) {
			if(lottoNumbers[j]>max) {
				max = lottoNumbers[j];
				count=j;
			}
		}
		
		int temp = lottoNumbers[len-i-1];
		lottoNumbers[len-i-1] =lottoNumbers[count];
		lottoNumbers[count] =temp; //여기를 수정, 위랑 비교해서
		
	}
		
	
//		for(int i=0;i<lottoNumbers.length-1;i++) {
//			boolean changed = false;
//			for(int j=0; j<lottoNumbers.length-1-i;j++) {
//				if(lottoNumbers[j]>lottoNumbers[j+1]) {
//					int temp = lottoNumbers[j];
//					lottoNumbers[j]=lottoNumbers[j+1];
//					lottoNumbers[j+1] = temp;
//					changed = true;
//				}
//				
//			}
//			if(!changed) break; //선생님답
//		}
	

}

private int getRandomNumber() {
	Random rand = new Random();
	int randomNumber = rand.nextInt(45)+1;
	return randomNumber;
}

}//class end
