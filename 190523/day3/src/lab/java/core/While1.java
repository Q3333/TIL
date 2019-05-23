package lab.java.core;

public class While1 {

	public static void main(String[] args) {
		int count =0;
		while(count<10) {
			System.out.print(++count +" ");
		}
		System.out.println();
		System.out.println();

		
		
		//1. 1~10까지 누적합
		count = 0;
		int sum =0;
		
		while(count<10) {
			++count;
			sum += count; // sum = sum+ count
						  // sum =+ count? -> sum = count 를 10번한 것과 같은 결과
						  // 즉 sum = 1, sum =2 ... sum = 10이여서 결과는 sum = 10이 저장됨.
			
			//선생닙답 sum +=++count;
		}
		System.out.println("1~10까지의 누적합은 = " + sum);
		System.out.println();
		
		//2. 1~10까지 홀수만 출력
		
		count = 0;
		
		while(count<10) {
			++count;
			if(count%2!=0)System.out.println("1~10의 홀수 " + count);
			
			//선생님답 count 0, while(count<10),if(++count%2==1) System.out.println(count);
		}
		System.out.println();
		
		//3. 1~10까지 홀수를 역순으로 출력
		
		count = 10;
		
		while(count>0) {
			if(count%2!=0)System.out.println("1~10의 홀수의 역순 " +count);
			count--;
		}
		System.out.println();
		
		
	}
}
