package ua.rafael.jdbc.spring.function;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.rafael.jdbc.spring.function.config.FunctionConfig;
import ua.rafael.jdbc.spring.function.dao.ContactDao;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(FunctionConfig.class);
		ContactDao contactDao = context.getBean(ContactDao.class);
		System.out.println(contactDao.findFirstNameBy(1));
	}
}
