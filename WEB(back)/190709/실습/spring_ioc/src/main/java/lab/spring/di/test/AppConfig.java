package lab.spring.di.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lab.spring.di.service.HelloService;
import lab.spring.di.service.HelloServiceImpl;
import lab.string.di.persist.Message;

@Configuration
public class AppConfig {
	@Bean
	public HelloService hello() {
		Message msg = new Message();
		HelloServiceImpl service = new HelloServiceImpl(msg);
		return service;
	}
}
