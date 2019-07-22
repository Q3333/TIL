package lab.spring.di.test;

import java.util.Locale;

import javax.naming.Context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lab.spring.di.service.LoginService;

public class MessageTest {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("annotConfig.xml");
	
	
	Locale locale = Locale.getDefault();
	String greet = context.getMessage("greeting", new Object[0], locale);
	System.out.println("default locale 인삿말 : "+greet);
	
	Locale locale_en = Locale.ENGLISH;
	greet = context.getMessage("greeting", new Object[0], locale_en);
	System.out.println("ENGLISH locale 인삿말 : "+greet);
	
	LoginService proc = context.getBean("loginService", LoginService.class);
	
	String[] results = proc.login("admin", "a1234");
	//String[] results = proc.login("korea", "a1234");
	for (String m: results) {
		System.out.println(m);
		}
	}
}
