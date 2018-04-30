package ua.rafael.jdbc.spring.resultsetextractor.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.rafael.jdbc.spring.resultsetextractor.model.Contact;
import ua.rafael.jdbc.spring.resultsetextractor.model.ContactTelDetail;

@Repository
public class JdbcContactWithLyambda implements ContactDao {
	public static String FIND_All_QUERY = "SELECT c.id, c.first_name, c.last_name, c.birth_date,"
			+ "ctd.id AS contact_tel_id, ctd.tel_type, ctd.tel_number FROM contact AS c LEFT JOIN contact_tel_detail AS ctd ON c.id=ctd.contact_id";

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public JdbcContactWithLyambda() {
	}

	@Autowired
	public JdbcContactWithLyambda(DataSource dataSource) {
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
					contact.setBirthDate(rs.getDate("birth_date"));
					contact.setContactTelDetails(new ArrayList<ContactTelDetail>());
					contactMap.put(id, contact);
				}

				int contactTelDetailId = rs.getInt("contact_tel_id");
				if (contactTelDetailId > 0) {
					ContactTelDetail contactTelDetail = new ContactTelDetail();
					contactTelDetail.setTelType(rs.getString("tel_type"));
					contactTelDetail.setTelNumber(rs.getString("tel_number"));
					contactTelDetail.setId(contactTelDetailId);
					contactTelDetail.setContactId(rs.getInt("id"));
					contact.getContactTelDetails().add(contactTelDetail);
				}
			}
			return new ArrayList<Contact>(contactMap.values());
		});
	}
}
