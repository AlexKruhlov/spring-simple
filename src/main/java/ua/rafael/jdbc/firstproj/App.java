package ua.rafael.jdbc.firstproj;

import java.sql.Date;
import java.util.GregorianCalendar;

import ua.rafael.jdbc.firstproj.dao.ContactDao;
import ua.rafael.jdbc.firstproj.dao.PlainContactDao;
import ua.rafael.jdbc.firstproj.model.Contact;

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

	}
}
