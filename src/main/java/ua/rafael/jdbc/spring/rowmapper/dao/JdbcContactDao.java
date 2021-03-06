package ua.rafael.jdbc.spring.rowmapper.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.rafael.jdbc.spring.rowmapper.model.Contact;

@Repository
public class JdbcContactDao implements ContactDao {
	public static String FIRST_NAME = "first_name";
	public static String LAST_NAME = "last_name";
	public static String BIRTH_DATE = "birth_date";
	public static String CONTACT_ID = "id";
	public static String CONTACT_TABLE_NAME = "contact";

	public static String FIND_NAME_BY_ID_QUERY = "SELECT " + CONTACT_ID + "," + FIRST_NAME + "," + LAST_NAME + ","
			+ BIRTH_DATE + " FROM " + CONTACT_TABLE_NAME;

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private DataSource dataSource;

	public JdbcContactDao() {
	}

	@Autowired
	public JdbcContactDao(DataSource dataSource) {
		this.dataSource = dataSource;
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Contact> findAll() {
		return namedParameterJdbcTemplate.query(FIND_NAME_BY_ID_QUERY, new ContactMapper());
	}

	public static final class ContactMapper implements RowMapper<Contact> {

		@Override
		public Contact mapRow(ResultSet rs, int rowNum) throws SQLException {
			Contact resulcontact = new Contact();
			resulcontact.setId(rs.getInt(CONTACT_ID));
			resulcontact.setBirthDate(rs.getDate(BIRTH_DATE));
			resulcontact.setFirstName(rs.getString(FIRST_NAME));
			resulcontact.setLastName(rs.getString(LAST_NAME));
			return resulcontact;
		}
	}
}
