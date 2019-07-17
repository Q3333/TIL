package lab.spring.di.persist;

import org.springframework.stereotype.Component;

@Component("message")
//@Component
public class SimpleMessage {
	public String getMessage() {
		return "빈의 LifeCycle 이해";
	}
}
