package ua.rafael.jdbc.spring.mappingsqlquery.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ua.rafael.jdbc.spring.mappingsqlquery.model.Contact;

@Repository("contactDao")
public class ContactDaoImpl implements ContactDao {
	private DataSource dataSource;
	private FindAllContacts findAllContacts;

	@Autowired
	public ContactDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
		this.findAllContacts = new FindAllContacts(dataSource);
	}

	@Override
	public List<Contact> findAll() {
		return findAllContacts.execute();
	}
}
