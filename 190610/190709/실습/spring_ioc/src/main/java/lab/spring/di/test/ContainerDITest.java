package lab.spring.di.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lab.spring.di.service.HelloService;

public class ContainerDITest {
	public static void main(String args[]) {
		
		ApplicationContext context = 
 	new ClassPathXmlApplicationContext("application.xml");

		
		
//		
//		AnnotationConfigApplicationContext context = 
//				new AnnotationConfigApplicationContext(AppConfig.class);
//		

		
					
		String beanName = "hello";
		
		HelloService service = 
			context.getBean(beanName,HelloService.class);
		service.sayHello();
		
		HelloService service2 = 
				context.getBean(beanName,HelloService.class);
		service.sayHello();
		
		
		System.out.println("생성해준 빈이 SingLeton이라면 동일한 객체가 리턴됩니다." + (service==service2));		
		
		
	}
	
}
