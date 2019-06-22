package exercise.overall.processor;

public class ProcessorTest {

	public static void main(String[] args) {
		
		String s = "i`m so sorry, but i love you. 다 거짓말~~";
		
		Processor process[] = new Processor[] {
				new LowerCase (),new UpperCase(),new Splitter()
		};
		
		for(int i=0;i<process.length;i++) {
			System.out.println(process[i].name());
			System.out.println("결과 출력 : "+process[i].process(s));
			System.out.println();
		}
		
		
		
	}

}
