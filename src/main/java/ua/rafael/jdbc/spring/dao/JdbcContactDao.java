package ua.rafael.jdbc.spring.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ua.rafael.jdbc.spring.config.SqlExceptionCodesTranslator;

@Repository
public class JdbcContactDao implements ContactDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
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
		return null;
	}
}
