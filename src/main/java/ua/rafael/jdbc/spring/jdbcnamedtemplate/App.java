package ua.rafael.jdbc.spring.jdbcnamedtemplate;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.rafael.jdbc.spring.jdbcnamedtemplate.config.Config;
import ua.rafael.jdbc.spring.jdbcnamedtemplate.dao.ContactDao;

public class App {
	public static int FIRST_CONTACT_ID = 1;

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		ContactDao contactDao = applicationContext.getBean(ContactDao.class);
		System.out.println(contactDao);
		System.out.println(contactDao.findLastNameById(FIRST_CONTACT_ID));
	}
}
