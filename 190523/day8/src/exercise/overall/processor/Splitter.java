package exercise.overall.processor;

import java.util.Arrays;

public class Splitter extends Processor {
	public String process (Object input) {
		String a = input.toString();
		String[] test = a.split(" ");
		
		return Arrays.toString(test);
	}
}
//for(int i=0; i<test.length;i++) {
//if(test[i].equals(" ")) {
//	test[i] = (",");
//}
////if(test[i] = ("[") {
////	test[i] = null;
////}
//}

