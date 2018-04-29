package ua.rafael.jdbc.spring;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.rafael.jdbc.spring.config.Config;
import ua.rafael.jdbc.spring.dao.ContactDao;
import ua.rafael.jdbc.spring.dao.JdbcContactDao;

public class App {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		ContactDao contactDao = applicationContext.getBean(ContactDao.class);
		((JdbcContactDao)contactDao).setDataSource(dataSource);
	}
}
