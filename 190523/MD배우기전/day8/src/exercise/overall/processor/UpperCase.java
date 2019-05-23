package exercise.overall.processor;

public class UpperCase extends Processor{
	public String process (Object input) {

			String a = input.toString();
					
			return a.toUpperCase();

	}
}

//if(input instanceof String) {

//}
//else {
//	return null;
//}