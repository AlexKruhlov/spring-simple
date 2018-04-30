package ua.rafael.jdbc.spring.mappingsqlquery;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.rafael.jdbc.spring.mappingsqlquery.config.Config;
import ua.rafael.jdbc.spring.mappingsqlquery.dao.ContactDao;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		System.out.println(context.getBean("contactDao", ContactDao.class).findAll());
	}
}
