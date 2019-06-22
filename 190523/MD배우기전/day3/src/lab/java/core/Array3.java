package lab.java.core;

public class Array3 {

	public static void main(String[] args) {
		String word = args[0];
		int len = word.length(); // String.length는 문자열의 문자 갯수를 리턴해줌
		for(int i=len-1;i>=0;i--)
		{
			System.out.print(word.charAt(i));
			}
	
	
	
	
	}

}
