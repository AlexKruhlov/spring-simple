package ua.rafael.jdbc.spring.jdbcnamedtemplate.dao;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcContactDao implements ContactDao {
	public static String FIND_NAME_BY_ID_QUERY = "SELECT first_name FROM contact WHERE id=:";
	public static String CONTACT_ID = "contact_id";

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
	public String findLastNameById(Integer id) {
		Map<String, Object> namedParameters = new HashMap<>();
		namedParameters.put(CONTACT_ID, id);
		return namedParameterJdbcTemplate.queryForObject(FIND_NAME_BY_ID_QUERY + CONTACT_ID, namedParameters,
				String.class);
	}
}
