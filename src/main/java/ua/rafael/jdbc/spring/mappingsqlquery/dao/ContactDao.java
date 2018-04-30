package ua.rafael.jdbc.spring.mappingsqlquery.dao;

import java.util.List;

import ua.rafael.jdbc.spring.mappingsqlquery.model.Contact;

public interface ContactDao {

	List<Contact> findAll();
}
