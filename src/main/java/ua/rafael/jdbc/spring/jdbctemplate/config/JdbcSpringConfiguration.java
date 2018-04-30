package ua.rafael.jdbc.spring.jdbctemplate.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("ua/rafael/jdbc/spring/jdbctemplate/jdbc.properties")
public class JdbcSpringConfiguration {
	private static final String DRIVER = "jdbc.driver";
	private static final String URL = "jdbc.url";
	private static final String USER_NAME = "jdbc.username";
	private static final String PASSWORD = "jdbc.password";

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty(DRIVER));
		dataSource.setUrl(env.getProperty(URL));
		dataSource.setUsername(env.getProperty(USER_NAME));
		dataSource.setPassword(env.getProperty(PASSWORD));
		return dataSource;
	}
}
