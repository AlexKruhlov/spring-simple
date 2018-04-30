package ua.rafael.jdbc.spring.rowmapper;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.rafael.jdbc.spring.rowmapper.config.Config;
import ua.rafael.jdbc.spring.rowmapper.dao.ContactDao;

public class App {
	public static int FIRST_CONTACT_ID = 1;

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		ContactDao contactDao = applicationContext.getBean(ContactDao.class);
		System.out.println(contactDao.findAll());
	}
}
