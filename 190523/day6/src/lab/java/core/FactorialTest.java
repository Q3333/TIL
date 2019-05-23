package lab.java.core;

public class FactorialTest {

	public static int Factorial(int n) {
		int result = 0;
		
		if(n==1)result=1;
		else if(n>1) result=n*Factorial(n-1);
		
		return result;
		
	}
	public static void main(String[] args) {
		System.out.println(Factorial(5));

	}

}
