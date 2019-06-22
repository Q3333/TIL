package lab.java.core;

public class CalcTest {
	
	public static void main(String[] args) {
		Calc c = new Calc();
		int x=5, y=10;
		
		System.out.printf("%d + %d = %d \n",x,y,c.plus(x, y));
		System.out.printf("%d - %d = %d \n",x,y,c.minus(x, y));
		System.out.printf("%d * %d = %d \n",x,y,c.multiply(x, y));
		System.out.printf("%d / %d = %d \n",x,y,c.div(x, y));
		System.out.println(+x+" % "+y +" = "+c.mod(x, y));
	
		
		
		
	}

}

//°´Ã¼ »ý¼º
		//10+5
		//10-5
		//10*5
		//10/5
		//10%5
