package ua.rafael.jdbc.spring.function.dao;

import static java.sql.Types.INTEGER;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlFunction;
import org.springframework.stereotype.Component;

@Component
public class FindFirstNameBy extends SqlFunction<String> {
	public static String FIND_FIRST_NAME_QUERY = "SELECT findfirstnameby(:id)";

	@Autowired
	private DataSource dataSource;

	public FindFirstNameBy(DataSource ds) {
		super(ds, FIND_FIRST_NAME_QUERY);
		super.declareParameter(new SqlParameter("id", INTEGER));
		super.compile();
	}
}
