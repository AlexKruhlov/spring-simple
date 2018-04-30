package ua.rafael.jdbc.spring.mappingsqlquery.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

@Configuration
@PropertySource("ua/rafael/jdbc/spring/mappingsqlquery/jdbc.properties")
public class DataSourceConfig {
	public static String DRIVER = "jdbc.driver";
	public static String URL = "jdbc.url";
	public static String USER = "jdbc.username";
	public static String PASSWORD = "jdbc.password";
	public static String SQL_SCRIPT_PATH = "ua/rafael/jdbc/spring/mappingsqlquery/mydata";

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(env.getProperty(DRIVER));
		dataSource.setUrl(env.getProperty(URL));
		dataSource.setUsername(env.getProperty(USER));
		dataSource.setPassword(env.getProperty(PASSWORD));
		Resource resource = new ClassPathResource(SQL_SCRIPT_PATH);
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
		DatabasePopulatorUtils.execute(databasePopulator, dataSource);
		return dataSource;
	}
}
