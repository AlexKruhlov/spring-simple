package ua.rafael.jdbc.spring.getprimarykey;

import java.sql.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.rafael.jdbc.spring.getprimarykey.config.GetPrimaryKeyConfig;
import ua.rafael.jdbc.spring.getprimarykey.dao.GetPrimaryKeyContactDao;
import ua.rafael.jdbc.spring.getprimarykey.model.Contact;

public class App {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(GetPrimaryKeyConfig.class);
		Contact contact = new Contact();
		contact.setFirstName("InsertFirstName");
		contact.setLastName("InsertLastName");
		contact.setBirthDate(Date.valueOf("1985-12-12"));
		applicationContext.getBean("contactDao", GetPrimaryKeyContactDao.class).insert(contact);
	}
}
