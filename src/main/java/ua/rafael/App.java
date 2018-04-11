package ua.rafael;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
				
//				ClassPathXmlApplicationContext("spring-conf.xml");
		MessageRenderer messageRenderer = context.getBean("messageRenderer", MessageRenderer.class);
		messageRenderer.render();
	}
}
