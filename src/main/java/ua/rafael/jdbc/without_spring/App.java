package ua.rafael.jdbc.without_spring;

import java.sql.Date;
import java.util.GregorianCalendar;

import ua.rafael.jdbc.without_spring.dao.ContactDao;
import ua.rafael.jdbc.without_spring.dao.PlainContactDao;
import ua.rafael.jdbc.without_spring.model.Contact;

public class App {
	private static ContactDao contactDao = new PlainContactDao();

	public static void main(String[] args) {
		System.out.println(contactDao.findAll());

		Contact contact = new Contact();
		contact.setFirstName("Jacky");
		contact.setLastName("Chan");
		contact.setBirthDate(new Date(new GregorianCalendar(2001, 10, 1).getTime().getTime()));
		contactDao.insert(contact);
		System.out.println(contactDao.findAll());
		contactDao.delete(1);
		System.out.println(contactDao.findAll());
	}
}
