package ua.rafael.beaninit;

import javax.annotation.PostConstruct;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanInit {

	public BeanInit() {
		System.out.println("I am CONSTRUCTOR");
	}

	@PostConstruct
	public void init() {
		System.out.println("I am INIT method");
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		context.getBean(BeanInit.class);
	}
}
