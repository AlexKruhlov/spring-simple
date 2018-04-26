package ua.rafael.bean.appcontextaware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		context.getBean(FirstBean.class);
		context.getBean(SecondBean.class);
		System.out.println("App run...");
	}
}
