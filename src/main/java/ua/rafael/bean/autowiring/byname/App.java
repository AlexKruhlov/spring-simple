package ua.rafael.bean.autowiring.byname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		StandardOutMessageRenderer messageRenderer = context.getBean(StandardOutMessageRenderer.class);
		System.out.println(messageRenderer);
	}
}
