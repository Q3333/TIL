package lambda;

import java.util.Arrays;
import java.util.List;

public class FilterTest {

	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
		         new Member("Kush", Member.MALE, 40),
		         new Member("Pierre", Member.MALE, 22),
		         new Member("Jolie", Member.FEMALE, 18),
		         new Member("Sozi", Member.FEMALE, 22)
		        );
		        
		    double ageAvg = list.stream()
		           .filter(m -> m.getSex() == Member.MALE)
		           .mapToInt(Member :: getAge)
		           .average()
		           .getAsDouble();
		        
		     System.out.println("남자 평균 나이: " + ageAvg);

	}

}
