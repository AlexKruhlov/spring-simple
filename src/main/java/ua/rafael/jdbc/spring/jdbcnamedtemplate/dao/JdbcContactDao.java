package ua.rafael.jdbc.spring.jdbcnamedtemplate.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.rafael.jdbc.spring.jdbctemplate.config.SqlExceptionCodesTranslator;

@Repository
public class JdbcContactDao implements ContactDao {
	public static String FIND_NAME_BY_ID_QUERY = "SELECT first_name FROM contact WHERE id=?";

	private JdbcTemplate jdbcTemplate;
	private DataSource dataSource;

	public JdbcContactDao() {
	}

	@Autowired
	public JdbcContactDao(DataSource dataSource) {
		this.dataSource = dataSource;
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource);
		SqlExceptionCodesTranslator exceptionTranslator = new SqlExceptionCodesTranslator();
		exceptionTranslator.setDataSource(dataSource);
		jdbcTemplate.setExceptionTranslator(exceptionTranslator);
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String findLastNameById(Integer id) {
		return jdbcTemplate.queryForObject(FIND_NAME_BY_ID_QUERY, new Object[] { id }, String.class);
	}
}
