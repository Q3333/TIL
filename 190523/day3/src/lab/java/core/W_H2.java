package lab.java.core;

public class W_H2 {
	public static void main(String[] args) {
		for(int i=1;i<100;i++) {
			System.out.printf("i = %d ",i);
		
		int temp = i;
		
		
		do {
			if((temp%10)%3==0&&(temp%10)!=0)System.out.print("¦");
		}
		while((temp/=10)!=0);
		
		System.out.println();
		
		 // do while end 
		
			
		} //for end
	} //main end
}// class end
