package ua.rafael.bean.befordestroy;

import javax.annotation.PreDestroy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class BeanDestroy {

	public BeanDestroy() {
		System.out.println("I am CONSTRUCTOR");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("I am DESTROYER");
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		context.getBean(BeanDestroy.class);
		System.out.println("I'm doing something...");
		((AnnotationConfigApplicationContext) context).close();
	}
}
