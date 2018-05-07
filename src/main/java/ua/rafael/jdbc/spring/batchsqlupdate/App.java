package ua.rafael.jdbc.spring.batchsqlupdate;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import ua.rafael.jdbc.spring.batchsqlupdate.config.BatchSqlUpdateConfig;
import ua.rafael.jdbc.spring.batchsqlupdate.dao.ContactDao;
import ua.rafael.jdbc.spring.batchsqlupdate.model.Contact;
import ua.rafael.jdbc.spring.batchsqlupdate.model.ContactTelDetail;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BatchSqlUpdateConfig.class);
		ContactDao contactDao = context.getBean(ContactDao.class);
		Contact contact = new Contact();
		contact.setFirstName("FirstName");
		contact.setLastName("LastName");
		contact.setBirthDate(Date.valueOf("1969-05-06"));
		List<ContactTelDetail> contactTelDetails = new ArrayList<>(Arrays
				.asList(createContactTelDetail("Mobile", "050569636"), createContactTelDetail("Home", "044587998")));
		contact.setContactTelDetails(contactTelDetails);
		contactDao.insert(contact);
	}

	private static ContactTelDetail createContactTelDetail(String telType, String telNumber) {
		ContactTelDetail contactTelDetail = new ContactTelDetail();
		contactTelDetail.setTelType(telType);
		contactTelDetail.setTelNumber(telNumber);
		return contactTelDetail;
	};
}
