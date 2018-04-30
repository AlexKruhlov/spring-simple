package ua.rafael.jdbc.spring.resultsetextractor.dao;

import java.util.List;

import ua.rafael.jdbc.spring.resultsetextractor.model.Contact;

public interface ContactDao {

	List<Contact> findAll();
}
