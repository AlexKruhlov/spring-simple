package ua.rafael.jdbc.spring.rowmapper.dao;

import java.util.List;

import ua.rafael.jdbc.spring.rowmapper.model.Contact;

public interface ContactDao {

	List<Contact> findAll();
}
