package ua.rafael.jdbc.without_spring.dao;

import java.util.List;

import ua.rafael.jdbc.without_spring.model.Contact;

public interface ContactDao {
	List<Contact> findAll();

	List<Contact> findByFirstName(String firstName);

	String findLastNameById(Long id);

	String findFirstNameById(Long id);

	void insert(Contact contact);

	void update(Contact contact);

	void delete(Integer contactId);
}
