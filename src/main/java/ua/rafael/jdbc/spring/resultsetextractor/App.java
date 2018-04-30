package ua.rafael.jdbc.spring.resultsetextractor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.rafael.jdbc.spring.resultsetextractor.config.Config;
import ua.rafael.jdbc.spring.resultsetextractor.dao.ContactDao;
import ua.rafael.jdbc.spring.resultsetextractor.dao.JdbcContactWithLyambda;

public class App {
	public static int FIRST_CONTACT_ID = 1;

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		ContactDao contactDaoWithLyambda = applicationContext.getBean(JdbcContactWithLyambda.class);
		System.out.println(contactDaoWithLyambda.findAll());
	}
}
