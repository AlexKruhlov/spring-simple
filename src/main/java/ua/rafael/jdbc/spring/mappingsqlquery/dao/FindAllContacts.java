package ua.rafael.jdbc.spring.mappingsqlquery.dao;

import static java.util.Objects.isNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;

import ua.rafael.jdbc.spring.mappingsqlquery.model.Contact;

public class FindAllContacts extends MappingSqlQuery<Contact> {
	public static String FIRST_NAME = "first_name";
	public static String LAST_NAME = "last_name";
	public static String BIRTH_DATE = "birth_date";
	public static String TABLE_CONTACT = "contact";
	public static String FIND_ALL_CONTACTS_QUERY = "SELECT " + FIRST_NAME + "," + LAST_NAME + "," + BIRTH_DATE
			+ " FROM " + TABLE_CONTACT;

	public FindAllContacts(DataSource dataSource) {
		super(dataSource, FIND_ALL_CONTACTS_QUERY);
	}

	@Override
	protected Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
		Contact contact = null;
		if (!isNull(rs)) {
			contact = new Contact();
			contact.setFirstName(rs.getString(FIRST_NAME));
			contact.setLastName(rs.getString(LAST_NAME));
			contact.setBirthDate(rs.getDate(BIRTH_DATE));
		}
		return contact;
	}
}
