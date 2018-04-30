package ua.rafael.jdbc.spring.rowmapper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.rafael.jdbc.spring.rowmapper.config.Config;
import ua.rafael.jdbc.spring.rowmapper.dao.ContactDao;
import ua.rafael.jdbc.spring.rowmapper.dao.JdbcContactDao;
import ua.rafael.jdbc.spring.rowmapper.dao.JdbcContactWithLyambda;

public class App {
	public static int FIRST_CONTACT_ID = 1;

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		ContactDao contactDao = applicationContext.getBean(JdbcContactDao.class);
		System.out.println(contactDao.findAll());
		ContactDao contactDaoWithLyambda = applicationContext.getBean(JdbcContactWithLyambda.class);
		System.out.println(contactDaoWithLyambda.findAll());
	}
}
