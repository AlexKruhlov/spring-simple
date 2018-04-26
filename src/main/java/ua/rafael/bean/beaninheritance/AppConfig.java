package ua.rafael.bean.beaninheritance;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public Mouse mouse() {
		Mouse mouse = new Mouse();
		initAnimal(mouse);
		mouse.setAge(25);
		mouse.setLocation("Europe");
		return mouse;
	}

	private void initAnimal(Animal animal) {
		animal.setAge(3);
		animal.setName("Animal");
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext();
		((AnnotationConfigApplicationContext) context).register(AppConfig.class);
		((AnnotationConfigApplicationContext) context).refresh();
		Mouse mouse = context.getBean(Mouse.class);
		System.out.println("Age " + mouse.getAge());
		System.out.println("Name " + mouse.getName());
		System.out.println("Location " + mouse.getLocation());
	}
}
