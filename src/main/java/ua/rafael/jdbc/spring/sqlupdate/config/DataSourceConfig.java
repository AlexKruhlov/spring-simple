package ua.rafael.jdbc.spring.sqlupdate.config;

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
@PropertySource("ua/rafael/jdbc/spring/sqlupdate/jdbc.properties")
public class DataSourceConfig {

	@Autowired
	Environment env;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource resultDataSource = new DriverManagerDataSource();
		resultDataSource.setDriverClassName(env.getProperty("jdbc.driver"));
		resultDataSource.setUrl(env.getProperty("jdbc.url"));
		resultDataSource.setUsername(env.getProperty("jdbc.username"));
		resultDataSource.setPassword(env.getProperty("jdbc.password"));
		Resource resource = new ClassPathResource("ua/rafael/jdbc/spring/sqlupdate/mydata");
		DatabasePopulator databasePopulator = new ResourceDatabasePopulator(resource);
		DatabasePopulatorUtils.execute(databasePopulator, resultDataSource);
		return resultDataSource;
	}
}
