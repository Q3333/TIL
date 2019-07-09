package lab.spring.di.service;

import lab.string.di.persist.Message;

public class HelloServiceImpl implements HelloService{
	
	private Message message;
	
	public HelloServiceImpl() {
		super();
	}
	
	
	
	public HelloServiceImpl(Message message) {
		super();
		this.message = message;
		System.out.println("생성자를 이용해서 Bean 주입함");
	}



	public void sayHello() {
		System.out.println(message.getMessage());
	}

	
	
	
//	
//	public void setMessage(Message message) {
//		this.message = message;
//	}
}
