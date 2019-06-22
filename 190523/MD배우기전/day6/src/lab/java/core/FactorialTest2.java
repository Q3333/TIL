package lab.java.core;

public class FactorialTest2 {
	
	public static long factorial(int n) {
		
		if(n<0||n>20) return -1;
		else if (n==1) return 1;
		else return n*(factorial(n-1));
		
	}
	
	public static void main(String[] args) {
		
		for(int i =1;i<=21;i++) {
			if(factorial(i)!=-1)System.out.printf("%2d!=%20d\n",i,factorial(i));
			else System.out.printf("유효하지 않은 값입니다. (0<n<=20) : %d",i);
		}
	}

}
