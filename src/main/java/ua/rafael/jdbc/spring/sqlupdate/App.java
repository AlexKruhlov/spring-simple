package ua.rafael.jdbc.spring.sqlupdate;

import java.sql.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.rafael.jdbc.spring.sqlupdate.config.Config;
import ua.rafael.jdbc.spring.sqlupdate.dao.ContactDaoImpl;
import ua.rafael.jdbc.spring.sqlupdate.model.Contact;

public class App {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
		Contact newContact = new Contact();
		newContact.setFirstName("MyFirstName");
		newContact.setLastName("MyLastName");
		newContact.setBirthDate(Date.valueOf("2018-2-6"));
		newContact.setId(1);
		applicationContext.getBean(ContactDaoImpl.class).update(newContact);
		//result inside database
	}
}
