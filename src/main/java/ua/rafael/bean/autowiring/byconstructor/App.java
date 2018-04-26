package ua.rafael.bean.autowiring.byconstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		MessageRenderer messageRenderer = context.getBean("messageRenderer", MessageRenderer.class);
		messageRenderer.render();
	}
}
