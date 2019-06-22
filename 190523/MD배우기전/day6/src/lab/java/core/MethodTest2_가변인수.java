package lab.java.core;

public class MethodTest2_가변인수 {

	public void method(String b, int ...c) { // 인자의 사이즈를 모를 때 사용
		System.out.println(c.length);		// 반드시 매개변수의 가장 마지막에 사용
		for(int num : c) {
			System.out.println(num);
		}
	}

	public static void main(String[] args) {
		MethodTest2_가변인수 test = new MethodTest2_가변인수();
		test.method("java", 5,6,7,8);
		int[] nums = new int[] {100,200,300,400,500};
		test.method("java",nums);
	}

}
