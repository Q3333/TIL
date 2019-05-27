package home.work;

import java.util.Random;

public class Day5_오름차순_뒤부터바꾸기 {

	public static void main(String[] args) {
		int a [] = new int[10];
		Random r = new Random();
		int rannum = 0;
		int count = 0;
		
		
		for(int i=0;i<a.length;i++) {
			rannum = r.nextInt(100)+1;
			a[i] = rannum;
		} // 난수 배열에 집어넣기
		
		
		for(int i=0;i<a.length;i++) {
			int max = 0;
			for(int j=0;j<a.length-i;j++) {
				if(a[j]>max) {
					count = j;
					max = a[j];
						}
				}		

			int temp = a[count];
			a[count] = a[a.length-i-1];
			a[a.length-i-1]=temp;
			} //이중 for문으로 풀기
		
//		for(int i=0;i<len;i++) {
//			int max = 0;
//			for(int j=0;j<len-i;j++) {
//				if(lottoNumbers[j]>max) {
//					max = lottoNumbers[j];
//					count=j;
//				}
//			}
//			
//			int temp = lottoNumbers[len-i-1];
//			lottoNumbers[len-i-1] =lottoNumbers[count];
//			lottoNumbers[count] =temp; //여기를 수정, 위랑 비교해서
//			
//		}
		
		
		for(int num : a) {
			System.out.print(num +" ");
		}
		
		

	} //main end

}//class end
