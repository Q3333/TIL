package lab.spring.di.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import lab.spring.di.persist.Message;
import lab.spring.di.persist.SimpleMessage;



@Service("hello")
public class HelloServiceImpl implements HelloService{
	//@Autowired
	//@Qualifier("simple")
	@Resource(name = "detail")
	
	private Message message;
	
	public HelloServiceImpl() {
		super();
	}

	public void sayHello() {
		System.out.println(message.getMessage());
	}

	
	//@Autowired
	public void setMessage(Message message) {
		this.message = message;
	}
	
	
//	
//	public HelloServiceImpl(Message message) {
//		super();
//		this.message = message;
//		System.out.println("생성자를 이용해서 Bean 주입함");
//	}
//
	
}
