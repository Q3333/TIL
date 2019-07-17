package lab.spring.di.persist;

import org.springframework.stereotype.Component;

@Component("simple")
public class SimpleMessage2 implements Message {
	public String getMessage() {
		return "씸플";
	}
}
