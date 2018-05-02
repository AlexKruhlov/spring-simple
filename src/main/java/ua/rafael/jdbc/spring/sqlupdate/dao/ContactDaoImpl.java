package ua.rafael.jdbc.spring.sqlupdate.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.rafael.jdbc.spring.sqlupdate.model.Contact;

@Repository
public class ContactDaoImpl implements ContactDao {
	private DataSource dataSource;
	private ContactUpdate contactUpdate;

	@Autowired
	public ContactDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		this.contactUpdate = new ContactUpdate(dataSource);
	}

	@Override
	public void update(Contact contact) {
		Map<String, Object> contactMap = new HashMap<>();
		contactMap.put("first_name", contact.getFirstName());
		contactMap.put("last_name", contact.getLastName());
		contactMap.put("birth_date", contact.getBirthDate());
		contactMap.put("id", contact.getId());
		contactUpdate.updateByNamedParam(contactMap);
	}
}
