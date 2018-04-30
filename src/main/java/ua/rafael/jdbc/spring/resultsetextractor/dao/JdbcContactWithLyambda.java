package ua.rafael.jdbc.spring.resultsetextractor.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.rafael.jdbc.spring.resultsetextractor.model.Contact;
import ua.rafael.jdbc.spring.resultsetextractor.model.ContactTelDetail;

@Repository
public class JdbcContactWithLyambda implements ContactDao {
	public static String FIND_All_QUERY = "SELECT c.id, c.first_name, c.last_name, c.birth_date,"
			+ "ctd.id, ctd.tel_type, ctd.tel_number As contact JOIN contact_tel_detail AS ctd ON c.id=ctd.contact_id";

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private DataSource dataSource;

	public JdbcContactWithLyambda() {
	}

	@Autowired
	public JdbcContactWithLyambda(DataSource dataSource) {
		this.dataSource = dataSource;
		NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Contact> findAll() {

		return namedParameterJdbcTemplate.query(FIND_All_QUERY, (ResultSet rs) -> {
			Map<Integer, Contact> contactMap = new HashMap<>();
			Contact contact = null;

			while (rs.next()) {
				int id = rs.getInt("id");
				contact = contactMap.get(id);

				if (Objects.isNull(contact)) {
					contact = new Contact();
					contact.setId(id);
					contact.setFirstName(rs.getString("first_name"));
					contact.setLastName(rs.getString("last_name"));
					contact.setBirthDate(rs.getDate("birth_day"));
					contact.setContactTelDetails(new ArrayList<ContactTelDetail>());
					contactMap.put(id, contact);
				}
			}

			return null;
		});
	}
}
