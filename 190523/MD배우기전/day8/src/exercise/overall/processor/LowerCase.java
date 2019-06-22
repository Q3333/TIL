package exercise.overall.processor;

public class LowerCase extends Processor{
	
	public String process (Object input) {
		String a = input.toString();
				
		return a.toLowerCase();
		
	}
}
