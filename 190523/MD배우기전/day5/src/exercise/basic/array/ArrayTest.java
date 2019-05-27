package exercise.basic.array;

public class ArrayTest {

	public static void main(String[] args) {
		Array a = new Array("A",3,4);
		Array b = new Array("B",3,4);
				
		
		a.makeArrayData();
		b.makeArrayData();
		
		System.out.println("##첫번째 Array 출력");
		a.printArray();
		System.out.println("##두번째 Array 출력");
		b.printArray();
		
		a.findMatchNumber(a, b);
	

		
	}

}
