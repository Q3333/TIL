package lab.java.core;

public class Operator2 {

	public static void main(String[] args) {
		// shift 연산자 (<<,>>,>>>)
		
		int a = 3;
		System.out.println(a<<5); // 비트를 왼쪽으로 5칸이동, 오른쪽 비트는 0으로 채움
								  // 1,2 -> 32,64 = 96 or
							      // x << y -> x * 2^y와 같음, 즉 3*2^5 = 3*32
		int b = 256;
		System.out.println(b>>3); // 비트를 오른쪽으로 3칸이동, 왼쪽 비트는 sign비트로채움
								  // X>>Y는 X/2^Y의 결과와 같다.
								  // 256 >> 3은 256/8
		
		System.out.println(-b>>3);// 양수를 음수로 만들땐 2의 보수를 취하면 됨.
								  // 음수 byte값을 다시 양수로 만들 땐 다시 2의 보수
								  // 어렵
		
		System.out.println(b>>>3); // >>>는 오른쪽으로 비트를 이동시키고, 왼쪽비트는 무조건 0으로 채움
		System.out.println(-b>>>3); // >>와 달리 sign비트로 채우는게 아님, 자주 사용X
	
	
		b += 4; // b = b+4; 와 같은 의미, 가독성은 떨어짐.
		System.out.println(b);
	
	}

}
