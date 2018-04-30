package ua.rafael.jdbc.spring.resultsetextractor.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
@PropertySource("ua/rafael/jdbc/spring/resultsetextractor/jdbc.properties")
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
		Resource resourceInitSchema = new ClassPathResource("ua/rafael/jdbc/spring/resultsetextractor/mydata");
		DatabasePopulator databasePopulator = new ResourceDatabasePopulator(resourceInitSchema);
		DatabasePopulatorUtils.execute(databasePopulator, dataSource);
		return dataSource;
	}
}
