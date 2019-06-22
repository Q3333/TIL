package lab.java.core;

import java.util.Scanner;

public class Array_H1 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("주민번호 입력(예 123456-7891234) : ");
		String juminStr = input.next();
		int[] jumin = new int[13];
		//int[] check = new int[12];
		int sum =0;
	
		
		for(int i=0, j=0;i<juminStr.length();i++) {
			if(i==6)continue;
			jumin[j++]=juminStr.charAt(i)-'0'; //방법은 2가지 -48하거나 문자 '0'을 뺌
		}
		
		
		for(int i=0,count=2; i<jumin.length-1;i++) {
			
			//check[i]=jumin[i]*count;
			sum+=jumin[i]*count;
			count++;
			if(count>9)count=2;
			
		}
		
		System.out.println(sum);
		
		int dig = 11-sum%11;
		if(dig>9)dig=dig%10;
		
		//선생님답 int dig=(11-sum%11)%10 (일의자리는 %10해도 변화가없기때문)
		
		if(jumin[12]==dig)System.out.println("1. 맞는 주민번호입니다.");
		else System.out.println("1. 틀린 주민번호입니다.");
		
		
		if(jumin[6]==1||jumin[6]==3)System.out.println("2. 남자입니다.");
		else if(jumin[6]==2||jumin[6]==4)System.out.println("2. 여자입니다.");
		
		
		System.out.printf("3. %d0년대 생입니다.",jumin[0]);
		
		
		
	}

}

//1.주민번호체크 %11 -10
//2.남자인지여자인지
//3.1900년도인지 2000년도인지

//종합을 11로 나눈 나머지를 구합니다.그 나머지를 11에서 뺀 결과가 check digit입니다.
//뺀 결과가 2자리수인 경우에는 2자리수를 10으로 나눈 나머지가 check digit가 됩니다.
//Hint> (11-나머지)%10또는(11total%11)%10;


